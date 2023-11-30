package imbesky.simpleforum.domain.dto;

public record PostEditDto(
        long id,
        String password,
        String title,
        String content
) {
    public static PostEditDto of(final long id,final String password, final String title, final String content) {
        return new PostEditDto(id, password, title, content);
    }
}
