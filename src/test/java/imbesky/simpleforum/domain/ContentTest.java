package imbesky.simpleforum.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import imbesky.simpleforum.exception.ContentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContentTest {
    @Test
    @DisplayName("공백 테스트")
    void blank(){
        final String input = "        ";

        assertThrows(ContentException.class, ()->{
            new Content(input);
        });
    }

    @Test
    @DisplayName("최대 길이 이상 입력")
    void lengthOverMax(){
        final String input = "1234567890".repeat(100).concat("f");

        assertThatThrownBy(()->{
            new Content(input);
        }).isInstanceOf(ContentException.class);
    }
}
