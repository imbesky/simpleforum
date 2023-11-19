package imbesky.simpleforum.controller;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import imbesky.simpleforum.service.EditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class EditController {
    private final EditService editService;
    public EditController(final EditService editService) {
        this.editService = editService;
    }

    @GetMapping("/edit")
    public void editMapping(@RequestParam final long id, final Model model){
        model.addAttribute("id", id);
    }

    @PostMapping("/edit-pwcheck")
    public String checkPassword(@RequestParam final long id, final Model model, final PasswordDto passwordDto){
        if (editService.check(passwordDto)){
            final PostSaveDto original = editService.originalPost(passwordDto.id());
            model.addAttribute("post", original);
            model.addAttribute("id", id);
            return "/editor-edit";
        }
        return "/pwerror";
    }
}
