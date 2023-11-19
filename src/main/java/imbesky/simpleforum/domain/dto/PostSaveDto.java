package imbesky.simpleforum.domain.dto;

public class PostSaveDto {
    private final String password;
    private final String author;
    private final String title;
    private final String content;

    public PostSaveDto(String password, String author, String title, String content) {
        this.password = password;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
