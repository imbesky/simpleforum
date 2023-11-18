package com.besky.simpleforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.besky.simpleforum.service.PostService;
@Controller
public class EditorController {
    private final PostService postService;
    public EditorController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/editor")
    public String createEditor(){
        return "/editor";
    }
}