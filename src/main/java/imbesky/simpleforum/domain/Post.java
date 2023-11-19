package imbesky.simpleforum.domain;

import imbesky.simpleforum.domain.dto.PostSaveDto;
import java.time.LocalDate;

public class Post {
    private long id;
    private Password password;
    private final Author author;
    private Title title;
    private final WrittenDate writtenDate;
    private Content content;
    public Post(final PostSaveDto postSaveDto){
        password = new Password(postSaveDto.password());
        author = new Author(postSaveDto.author());
        title = new Title(postSaveDto.title());
        writtenDate = new WrittenDate();
        content = new Content(postSaveDto.content());
    }
    public long postId(){
        return id;
    }
    public String authorName(){
        return author.authorName();
    }
    public String getPassword(){
        return password.getPassword();
    }
    public String shortTitle(){
        return title.shortTitle();
    }
    public String fullTitle(){
        return title.fullTitle();
    }
    public LocalDate writtenDate(){
        return writtenDate.initialWrittenDate();
    }
    public long passedDayUntilNow(){
        return writtenDate.passedDayUntilNow();
    }
    public String shortContent(){
        return content.shortContent();
    }
    public String fullContent(){
        return content.fullContent();
    }
    public void resetPassword(final String string){
        this.password = new Password(string);
    }
    public void editTitle(final String string){
        this.title = new Title(string);
    }
    public void editContent(final String string){
        this.content = new Content(string);
    }
}
