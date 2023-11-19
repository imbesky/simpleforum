package imbesky.simpleforum.domain.dto;

public record PasswordDto(
        long id,
        String inputPassword
) {
    public static PasswordDto of(final long id, final String input){
        return new PasswordDto(id, input);
    }
}