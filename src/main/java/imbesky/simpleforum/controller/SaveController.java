package imbesky.simpleforum.controller;

import imbesky.simpleforum.domain.dto.PostSaveDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import imbesky.simpleforum.form.SaveForm;
import imbesky.simpleforum.service.SaveService;

@Controller
public class SaveController {
    private final SaveService saveService;
    public SaveController(SaveService saveService) {
        this.saveService = saveService;
    }

    @PostMapping("/submitpost")
    public String postCreate(final SaveForm form){
        saveService.savePost(new PostSaveDto(form.getPassword(),form.getAuthor(),form.getTitle(),form.getContent()));
        return "redirect:/";
    }
}
