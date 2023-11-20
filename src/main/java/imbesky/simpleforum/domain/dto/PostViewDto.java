package imbesky.simpleforum.domain.dto;

public record PostViewDto(
        long id,
        String author,
        String title,
        String writtenDate,
        String content
) {
    public static PostViewDto of(final long id, final String author, final String title, final String writtenDate, final String content){
        return new PostViewDto(id, author, title, writtenDate, content);
    }
}
