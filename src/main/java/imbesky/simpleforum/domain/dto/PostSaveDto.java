package imbesky.simpleforum.domain.dto;

import imbesky.simpleforum.domain.Post;

public record PostSaveDto(
        String password,
        String author,
        String title,
        String content
) {
    public static PostSaveDto of(final String password, final String author, final String title, final String content) {
        return new PostSaveDto(password, author, title, content);
    }
    public static PostSaveDto from(final Post post){
        return new PostSaveDto(post.getPassword(),post.authorName(),post.fullTitle(),post.fullContent());
    }
}
