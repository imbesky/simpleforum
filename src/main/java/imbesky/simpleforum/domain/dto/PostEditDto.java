package imbesky.simpleforum.domain.dto;

public record PostEditDto(
        String password,
        String title,
        String content
) {
    public static PostEditDto of(final String password, final String title, final String content) {
        return new PostEditDto(password, title, content);
    }
}
