package imbesky.simpleforum.domain;

import imbesky.simpleforum.domain.dto.PostEditDto;
import imbesky.simpleforum.domain.dto.PostPreviewDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import imbesky.simpleforum.domain.dto.PostViewDto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private Password password;
    @Embedded
    private Author author;
    @Embedded
    private Title title;
    @Embedded
    private WrittenDate writtenDate;
    @Embedded
    private Content content;
    public Post(){
    }
    private Post(final PostSaveDto postSaveDto){
        password = new Password(postSaveDto.password());
        author = new Author(postSaveDto.author());
        title = new Title(postSaveDto.title());
        writtenDate = new WrittenDate();
        content = new Content(postSaveDto.content());
    }
    public static Post from(final PostSaveDto postSaveDto){
        return new Post(postSaveDto);
    }
    public PostViewDto toPostViewDto(){
        return PostViewDto.of(id, author.authorName(), title.fullTitle(),
                writtenDate.initialWrittenDate(), content.fullContent());
    }

    public PostPreviewDto toPostPreviewDto(){
        return PostPreviewDto.of(id, author.authorName(), title.shortTitle(), writtenDate.initialWrittenDate());
    }

    public long Id(){
        return id;
    }

    public boolean checkPassword(final String input){
        return password.check(input);
    }

    public void editPost(final PostEditDto postEditDto){
        password = new Password(postEditDto.password());
        title = new Title(postEditDto.title());
        content = new Content(postEditDto.content());
    }
}
