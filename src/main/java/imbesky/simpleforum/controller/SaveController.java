package imbesky.simpleforum.controller;

import static imbesky.simpleforum.constant.Format.LIST_PAGE_URL;
import static imbesky.simpleforum.constant.Format.REDIRECT_URL;
import static imbesky.simpleforum.constant.Format.SUBMIT;

import imbesky.simpleforum.domain.dto.PostEditDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import imbesky.simpleforum.service.SaveService;

@Controller
public class SaveController implements PostController{
    private final SaveService saveService;

    @Autowired
    public SaveController(SaveService saveService) {
        this.saveService = saveService;
    }

    @GetMapping("/editor")
    public void editor(final Model model){
        setNames(model);
        setNotices(model);
        model.addAttribute("submitNotice", SUBMIT);
    }

    @PostMapping("/submitpost")
    public String savePost(final PostSaveDto postSaveDto){
        saveService.saveEditedPost(postSaveDto);
        return REDIRECT_URL.concat(LIST_PAGE_URL);
    }

    @PostMapping("/editpost")
    public String saveEditedPost(final PostEditDto postEditDto) {
        saveService.saveEditedPost(postEditDto);
        return REDIRECT_URL.concat(LIST_PAGE_URL);
    }
}
