package imbesky.simpleforum.domain.dto;

public record PostSaveDto(
        String password,
        String author,
        String title,
        String content
) {
    public static PostSaveDto of(final String password, final String author, final String title, final String content) {
        return new PostSaveDto(password, author, title, content);
    }
}
