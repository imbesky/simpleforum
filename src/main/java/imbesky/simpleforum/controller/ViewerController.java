package imbesky.simpleforum.controller;

import static imbesky.simpleforum.constant.Format.DELETE;
import static imbesky.simpleforum.constant.Format.EDIT;
import static imbesky.simpleforum.constant.Format.LIST_PAGE_URL;
import static imbesky.simpleforum.constant.Format.LIST_PAGE_NOTICE;
import static imbesky.simpleforum.constant.Format.REDIRECT_URL;
import static imbesky.simpleforum.constant.Format.WRITE;

import imbesky.simpleforum.service.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewerController implements PostController{
    private final ViewerService viewerService;

    @Autowired
    public ViewerController(ViewerService viewerService) {
        this.viewerService = viewerService;
    }

    @GetMapping("/")
    public String indexPage(){
        return REDIRECT_URL.concat("list");
    }

    @GetMapping("/list")
    public void list(final Model model){
        model.addAttribute("posts", viewerService.previews());
        model.addAttribute("write",WRITE);
        setNames(model);
    }

    @GetMapping("/view")
    public String postViewer(@RequestParam final long id, final Model model){
        model.addAttribute("post", viewerService.viewPost(id));
        model.addAttribute("list", LIST_PAGE_URL);
        model.addAttribute("toList", LIST_PAGE_NOTICE);
        model.addAttribute("editNotice", EDIT);
        model.addAttribute("deleteNotice", DELETE);
        setNames(model);
        return "viewer";
    }
}
