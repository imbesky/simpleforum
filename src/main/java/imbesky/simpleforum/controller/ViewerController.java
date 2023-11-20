package imbesky.simpleforum.controller;

import imbesky.simpleforum.domain.dto.PostViewDto;
import imbesky.simpleforum.domain.dto.PostPreviewDto;
import imbesky.simpleforum.service.ViewerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewerController {
    private final ViewerService viewerService;

    @Autowired
    public ViewerController(ViewerService viewerService) {
        this.viewerService = viewerService;
    }

    @GetMapping("/")
    public String list(final Model model){
        final List<PostPreviewDto> posts = viewerService.previews();
        model.addAttribute("posts",posts);
        return "list";
    }

    @GetMapping("/view")
    public String postViewer(@RequestParam final long id, final Model model){
        final PostViewDto post = viewerService.viewPost(id);
        model.addAttribute("post", post);
        return "viewer";
    }
}
