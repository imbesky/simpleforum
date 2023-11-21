package imbesky.simpleforum.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertThrows;

import imbesky.simpleforum.exception.PasswordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordTest {
    @Test
    @DisplayName("정상적인 비밀번호 체크")
    void validPasswordCheck(){
        final String input = "abcd";

        final Password password = new Password(input);

        assertThat(password.check("abcd")).isTrue();
    }

    @Test
    @DisplayName("4글자가 아닌 비밀번호")
    void notProperLength(){
        final String input = "abc";

        assertThatIllegalArgumentException().isThrownBy(()->{
            new Password(input);
        });
    }

    @Test
    @DisplayName("특수문자가 포함된 비밀번호")
    void invalidCharacterIncluded(){
        final String input = "abc!";

        assertThrows(PasswordException.class, () -> {
            new Password(input);
        });
    }

    @Test
    @DisplayName("공백이 포함된 비밀번호")
    void blankIncluded(){
        final String input = "a bc";

        assertThrows(PasswordException.class, () -> {
            new Password(input);
        });
    }
}
