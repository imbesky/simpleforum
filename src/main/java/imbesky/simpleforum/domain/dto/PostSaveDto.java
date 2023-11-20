package imbesky.simpleforum.domain.dto;

public record PostSaveDto (
        String password,
        String author,
        String title,
        String content
) {
}
