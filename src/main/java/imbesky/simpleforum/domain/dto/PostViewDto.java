package imbesky.simpleforum.domain.dto;

import imbesky.simpleforum.domain.Post;
import java.time.LocalDate;

public record PostViewDto(
        long id,
        String author,
        String title,
        LocalDate writtenDate,
        String content
) {
    public static PostViewDto of(final Post post){
        return new PostViewDto(post.postId(),post.authorName(),post.fullTitle(),post.writtenDate(),post.fullContent());
    }
}
