package imbesky.simpleforum.controller;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    private final DeleteService deleteService;

    @Autowired
    public DeleteController(DeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @GetMapping("/delete")
    public void delete(@RequestParam final long id, final Model model){
        model.addAttribute("id", id);
    }

    @PostMapping("/deletepost")
    public String postDelete(@RequestParam final long id, final PasswordDto passwordDto){
        if (deleteService.checkPassword(passwordDto)){
            deleteService.deletePost(id);
            return "redirect:/";
        }
        return "/password-error";
    }
}
