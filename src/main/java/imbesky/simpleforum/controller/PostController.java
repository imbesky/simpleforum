package imbesky.simpleforum.controller;

import static imbesky.simpleforum.constant.Element.AUTHOR;
import static imbesky.simpleforum.constant.Element.CONTENT;
import static imbesky.simpleforum.constant.Element.ID;
import static imbesky.simpleforum.constant.Element.PASSWORD;
import static imbesky.simpleforum.constant.Element.TITLE;
import static imbesky.simpleforum.constant.Element.WRITTEN_DATE;
import static imbesky.simpleforum.constant.Format.INDEX_PAGE_NOTICE;
import static imbesky.simpleforum.constant.Format.INDEX_PAGE_URL;
import static imbesky.simpleforum.constant.Format.PASSWORD_ERROR;
import static imbesky.simpleforum.constant.Format.REDIRECT_NOTICE;
import static imbesky.simpleforum.constant.Format.REDIRECT_URL;

import imbesky.simpleforum.domain.Author;
import imbesky.simpleforum.domain.Content;
import imbesky.simpleforum.domain.Password;
import imbesky.simpleforum.domain.Title;
import org.springframework.ui.Model;

public interface PostController {
    default void setNames(final Model model) {
        model.addAttribute("id", ID.getName());
        model.addAttribute("title", TITLE.getName());
        model.addAttribute("author", AUTHOR.getName());
        model.addAttribute("content", CONTENT.getName());
        model.addAttribute("writtenDate", WRITTEN_DATE.getName());
        model.addAttribute("password", PASSWORD.getName());
    }

    default void setNotices(final Model model){
        model.addAttribute("titleNotice",
                String.format(TITLE.getNotice(), Title.MIN_LENGTH,Title.MAX_LENGTH));
        model.addAttribute("authorNotice",
                String.format(AUTHOR.getNotice(), Author.MIN_LENGTH, Author.MAX_LENGTH));
        model.addAttribute("contentNotice",
                String.format(CONTENT.getNotice(), Content.MIN_LENGTH, Content.MAX_LENGTH));
        model.addAttribute("passwordNotice",
                String.format(PASSWORD.getNotice(), Password.PROPER_LENGTH));
    }

    default String  toErrorPage(final Model model){
        model.addAttribute("passwordError", PASSWORD_ERROR);
        model.addAttribute("redirectUrl", REDIRECT_URL);
        model.addAttribute("redirectNotice", REDIRECT_NOTICE);
        model.addAttribute("indexUrl", INDEX_PAGE_URL);
        model.addAttribute("indexNotice", INDEX_PAGE_NOTICE);
        return "/password-error";
    }
}
