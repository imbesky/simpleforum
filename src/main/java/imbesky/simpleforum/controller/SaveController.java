package imbesky.simpleforum.controller;

import imbesky.simpleforum.domain.dto.PostSaveDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import imbesky.simpleforum.service.SaveService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaveController {
    private final SaveService saveService;
    public SaveController(SaveService saveService) {
        this.saveService = saveService;
    }

    @PostMapping("/submitpost")
    public String savePost(final PostSaveDto postSaveDto){
        saveService.savePost(postSaveDto);
        return "redirect:/";
    }
    @PostMapping("/editpost")
    public String saveEditedPost(@RequestParam final long id, final PostSaveDto postSaveDto) {
        saveService.savePost(postSaveDto);
        return "redirect:/";
    }
}
