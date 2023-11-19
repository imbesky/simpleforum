package imbesky.simpleforum.controller;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostDto;
import imbesky.simpleforum.domain.dto.PostsDto;
import imbesky.simpleforum.service.ViewerService;
import java.util.List;
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
    public String list(Model model){
        PostsDto posts = viewerService.posts();
        model.addAttribute("postsNumber",posts.getPostsNumber());
        model.addAttribute("ids", posts.getIds());
        model.addAttribute("authors",posts.getAuthors());
        model.addAttribute("titles",posts.getTitles());
        model.addAttribute("writtenDates",posts.getWrittenDates());
        return "list";
    }

    @GetMapping("/view")
    public String postViewer(@RequestParam final int id, final Model model){
        PostDto post = viewerService.inquirePost(id);
        model.addAttribute("post", post);
        return "viewer";
    }
}
