package imbesky.simpleforum.controller;

import static imbesky.simpleforum.constant.EditorNotice.AUTHOR_NOTICE;
import static imbesky.simpleforum.constant.EditorNotice.CONTENT_NOTICE;
import static imbesky.simpleforum.constant.EditorNotice.PASSWORD_NOTICE;
import static imbesky.simpleforum.constant.EditorNotice.SUBMIT;
import static imbesky.simpleforum.constant.EditorNotice.TITLE_NOTICE;

import imbesky.simpleforum.domain.Author;
import imbesky.simpleforum.domain.Content;
import imbesky.simpleforum.domain.Password;
import imbesky.simpleforum.domain.Title;
import imbesky.simpleforum.domain.dto.PostEditDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import imbesky.simpleforum.service.SaveService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaveController {
    private final SaveService saveService;

    @Autowired
    public SaveController(SaveService saveService) {
        this.saveService = saveService;
    }

    @GetMapping("/editor")
    public void editor(final Model model){
        model.addAttribute("titleNotice",
                String.format(TITLE_NOTICE, Title.MIN_LENGTH,Title.MAX_LENGTH));
        model.addAttribute("authorNotice",
                String.format(AUTHOR_NOTICE, Author.MIN_LENGTH, Author.MAX_LENGTH));
        model.addAttribute("contentNotice",
                String.format(CONTENT_NOTICE, Content.MIN_LENGTH, Content.MAX_LENGTH));
        model.addAttribute("passwordNotice",
                String.format(PASSWORD_NOTICE, Password.PROPER_LENGTH));
        model.addAttribute("submitNotice",SUBMIT);
    }

    @PostMapping("/submitpost")
    public String savePost(final PostSaveDto postSaveDto){
        saveService.saveEditedPost(postSaveDto);
        return "redirect:/";
    }

    @PostMapping("/editpost")
    public String saveEditedPost(@RequestParam final long id, final PostEditDto postEditDto) {
        saveService.saveEditedPost(id, postEditDto);
        return "redirect:/";
    }
}
