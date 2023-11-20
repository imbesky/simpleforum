package imbesky.simpleforum.domain.dto;

import java.time.LocalDate;

public record PostViewDto(
        long id,
        String author,
        String title,
        LocalDate writtenDate,
        String content
) {
    public static PostViewDto of(final long id, final String author, final String title, final LocalDate writtenDate, final String content){
        return new PostViewDto(id, author, title, writtenDate, content);
    }
}
