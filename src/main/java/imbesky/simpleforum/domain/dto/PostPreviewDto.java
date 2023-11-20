package imbesky.simpleforum.domain.dto;

import java.time.LocalDate;

public record PostPreviewDto(
        long id,
        String author,
        String title,
        LocalDate writtenDate
){
    public static PostPreviewDto of(final long id, final String author, final String title, final LocalDate writtenDate){
        return new PostPreviewDto(id, author, title, writtenDate);
    }
}
