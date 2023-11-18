package simpleforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import simpleforum.domain.Post;
import simpleforum.service.PostService;
@Controller
public class EditController {
    private final PostService postService;
    public EditController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/edit")
    public void edit(@RequestParam int number, Model model){
        model.addAttribute("number", number);
    }

    @PostMapping("/edit-pwcheck")
    public String edit(@RequestParam int number, Model model, EditForm form){
        if (postService.check(number, form.getInputPW())) {
            Post post = postService.returnList().get(number);
            model.addAttribute("post", post);
            return "/editor-edit";
        } else {
            return "/pwerror";
        }
    }
    @PostMapping("/editpost")
    public String postEdit(@RequestParam int number, EditPostForm postForm) {
        Post post = postService.returnList().get(number);
        post.setTitle(postForm.getTitle());
        post.setAuthor(postForm.getAuthor());
        post.setContent(postForm.getContent());
        post.setPassWord(postForm.getPassword());
        postService.postEdit(number, post);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public void delete(@RequestParam int number, Model model){
        model.addAttribute("number", number);
    }
    @PostMapping("/deletepost")
    public String postDelete(@RequestParam int number, DeleteForm form){
        if(postService.check(number, form.getInputPW())){
            postService.postDelete(number);
            return "redirect:/";
        }
        else {
            return "/pwerror";
        }
    }
}
