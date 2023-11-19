package imbesky.simpleforum.domain.dto;

import imbesky.simpleforum.domain.Author;
import imbesky.simpleforum.domain.Content;
import imbesky.simpleforum.domain.Password;
import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.Title;
import imbesky.simpleforum.domain.WrittenDate;
import java.time.LocalDate;

public class PostDto {
    private final long id;
    private final String author;
    private final String title;
    private final LocalDate writtenDate;
    private final String content;
    public PostDto(final Post post){
        id = post.postId();
        author = post.authorName();
        title = post.fullTitle();
        writtenDate = post.writtenDate();
        content = post.fullContent();
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getWrittenDate() {
        return writtenDate;
    }

    public String getContent() {
        return content;
    }
}
