package imbesky.simpleforum.domain;

import java.time.LocalDate;

public class Post {
    private long id;
    private Password password;
    private final Author author;
    private Title title;
    private final WrittenDate writtenDate;
    private Content content;
    public Post(Password password, Author author, Title title, Content content){
        this.password = password;
        this.author = author;
        this.title = title;
        this.writtenDate = new WrittenDate();
        this.content = content;
    }
    public long postId(){
        return id;
    }
    public String authorName(){
        return author.authorName();
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
