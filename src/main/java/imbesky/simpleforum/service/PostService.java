package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.dto.PasswordDto;

public interface PostService {
    boolean checkPassword(final PasswordDto passwordDto);
}