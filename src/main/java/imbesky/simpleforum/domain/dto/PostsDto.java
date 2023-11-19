package imbesky.simpleforum.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record PostsDto(
        int number,
        List<Long> ids,
        List<String> authors,
        List<String> titles,
        List<LocalDate> writtenDates
){
    public static PostsDto of(final List<Long> ids, final List<String> authors, final List<String> titles, final List<LocalDate> writtenDates){
        return new PostsDto(ids.size(), ids, authors, titles, writtenDates);
    }
}
