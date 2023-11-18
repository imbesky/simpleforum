package com.besky.simpleforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.besky.simpleforum.domain.Post;
import com.besky.simpleforum.service.PostService;

import java.io.PrintWriter;
import java.util.List;
@Controller
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String list(Model model){
        List<Post> posts = postService.returnList();
        model.addAttribute("posts", posts);
        return "list";
    }

    @GetMapping("/list")
    public String listReturn(Model model){
        List<Post> posts = postService.returnList();
        model.addAttribute("posts", posts);
        return "/list";
    }

    @GetMapping("/view")
    public String postViewer(@RequestParam int number, Model model){
        List<Post> post = postService.returnList();
        model.addAttribute("post", post.get(number));
        return "viewer";
    }

    @PostMapping("/submitpost")
    public String postCreate(PostForm form){
        Post post = new Post();
        post.setTitle(form.getTitle());
        post.setAuthor(form.getAuthor());
        post.setContent(form.getContent());
        post.setPassWord(form.getPassword());
        postService.postPost(post);
        return "redirect:/";
    }
}
