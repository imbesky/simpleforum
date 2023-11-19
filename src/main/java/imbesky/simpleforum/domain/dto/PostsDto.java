package imbesky.simpleforum.domain.dto;

import java.time.LocalDate;
import java.util.List;

public class PostsDto {
    private final int postsNumber;
    private final List<Long> ids;
    private final List<String> authors;
    private final List<String> titles;
    private final List<LocalDate> writtenDates;

    public PostsDto(List<Long> ids, List<String> authors, List<String> titles, List<LocalDate> writtenDates){
        postsNumber = ids.size();
        this.ids = ids;
        this.authors = authors;
        this.titles = titles;
        this.writtenDates = writtenDates;
    }

    public int getPostsNumber() {
        return postsNumber;
    }
    public List<Long> getIds() {
        return ids;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public List<String> getTitles() {
        return titles;
    }
    public List<LocalDate> getWrittenDates() {
        return writtenDates;
    }
}
