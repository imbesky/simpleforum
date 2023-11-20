package imbesky.simpleforum.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PostPreviewDto(
        long id,
        String author,
        String title,
        String writtenDate
){
    public static PostPreviewDto of(final long id, final String author, final String title, final String writtenDate){
        return new PostPreviewDto(id, author, title, writtenDate);
    }
}
