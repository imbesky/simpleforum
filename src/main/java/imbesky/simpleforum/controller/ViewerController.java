package imbesky.simpleforum.controller;

import imbesky.simpleforum.domain.dto.PostViewDto;
import imbesky.simpleforum.domain.dto.PostsDto;
import imbesky.simpleforum.service.ViewerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewerController {
    private final ViewerService viewerService;
    public ViewerController(ViewerService viewerService) {
        this.viewerService = viewerService;
    }

    @GetMapping("/")
    public String list(final Model model){
        final PostsDto posts = viewerService.posts();
        model.addAttribute("postsNumber",posts.number());
        model.addAttribute("ids", posts.ids());
        model.addAttribute("authors",posts.authors());
        model.addAttribute("titles",posts.titles());
        model.addAttribute("writtenDates",posts.writtenDates());
        return "list";
    }

    @GetMapping("/view")
    public String postViewer(@RequestParam final long id, final Model model){
        PostViewDto post = viewerService.inquirePost(id);
        model.addAttribute("post", post);
        return "viewer";
    }
}
