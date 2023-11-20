package imbesky.simpleforum.domain;

import imbesky.simpleforum.domain.dto.PostEditDto;
import imbesky.simpleforum.domain.dto.PostPreviewDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import imbesky.simpleforum.domain.dto.PostViewDto;

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

    public PostViewDto toPostViewDto(){
        return PostViewDto.of(id, author.authorName(), title.fullTitle(),
                writtenDate.initialWrittenDate(), content.fullContent());
    }

    public PostPreviewDto toPostPreviewDto(){
        return PostPreviewDto.of(id, author.authorName(), title.shortTitle(), writtenDate.initialWrittenDate());
    }

    public void editPost(final PostEditDto postEditDto){
        password = new Password(postEditDto.password());
        title = new Title(postEditDto.title());
        content = new Content(postEditDto.content());
    }
}
