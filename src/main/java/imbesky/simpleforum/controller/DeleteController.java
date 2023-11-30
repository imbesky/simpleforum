package imbesky.simpleforum.controller;

import static imbesky.simpleforum.constant.Element.ID;
import static imbesky.simpleforum.constant.Format.DELETE;
import static imbesky.simpleforum.constant.Format.ENTER;
import static imbesky.simpleforum.constant.Format.INPUT_PASSWORD;
import static imbesky.simpleforum.constant.Format.LIST_PAGE_URL;
import static imbesky.simpleforum.constant.Format.REDIRECT_URL;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController implements PostController{
    private final DeleteService deleteService;

    @Autowired
    public DeleteController(DeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @GetMapping("/delete")
    public void delete(@RequestParam final long id, final Model model){
        model.addAttribute("id", id);
        model.addAttribute("idName", ID.getName());
        model.addAttribute("inputPassword", INPUT_PASSWORD);
        model.addAttribute("deleteNotice", DELETE);
    }

    @PostMapping("/deletepost")
    public String postDelete(final PasswordDto passwordDto, final Model model){
        if (deleteService.checkPassword(passwordDto)){
            deleteService.deletePost(passwordDto.id());
            return REDIRECT_URL.concat(LIST_PAGE_URL);
        }
        return toErrorPage(model);
    }
}
