package imbesky.simpleforum.controller;

import static imbesky.simpleforum.constant.Element.ID;
import static imbesky.simpleforum.constant.Format.ENTER;
import static imbesky.simpleforum.constant.Format.INPUT_PASSWORD;
import static imbesky.simpleforum.constant.Format.SUBMIT;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.domain.dto.PostViewDto;
import imbesky.simpleforum.service.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class EditController implements PostController{
    private final EditService editService;

    @Autowired
    public EditController(final EditService editService) {
        this.editService = editService;
    }

    @GetMapping("/edit")
    public void editMapping(@RequestParam final long id, final Model model){
        model.addAttribute("id", id);
        model.addAttribute("idName", ID.getName());
        model.addAttribute("inputPassword", INPUT_PASSWORD);
        model.addAttribute("enterNotice", ENTER);
    }

    @PostMapping("/edit-password-check")
    public String checkPassword(final Model model, final PasswordDto passwordDto){
        if (editService.checkPassword(passwordDto)){
            return toEditor(model, editService.originalPost(passwordDto.id()));
        }
        return toErrorPage(model);
    }

    private String toEditor(final Model model, final PostViewDto post){
        model.addAttribute("post", post);
        setNames(model);
        setNotices(model);
        model.addAttribute("submitNotice",SUBMIT);
        return "/editor-edit";
    }
}
