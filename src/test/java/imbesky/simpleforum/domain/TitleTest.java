package imbesky.simpleforum.domain;

import static imbesky.simpleforum.constant.Format.DOTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import imbesky.simpleforum.exception.TitleException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TitleTest {

    @Test
    @DisplayName("공백 제목")
    void lengthUnderMin(){
        final String input = " ";

        assertThrows(TitleException.class, ()->{
            new Title(input);
        });
    }

    @Test
    @DisplayName("최대 길이 이상의 제목")
    void lengthOverMax(){
        final String input = "abcde".repeat(10).concat("a");

        assertThatThrownBy(()-> {
            new Title(input);
        }).isInstanceOf(TitleException.class);
    }

    @Test
    @DisplayName("짧은 제목 테스트")
    void shortTitle(){
        final String input = "abcde".repeat(10);

        final Title title = new Title(input);

        assertThat(title.shortTitle()).isEqualTo(input.substring(0,9).concat(DOTS));

    }

    @Test
    @DisplayName("전체 제목 테스트")
    void fullTitle(){
        final String input = "abcde".repeat(10);

        final Title title = new Title(input);

        assertThat(title.fullTitle()).isEqualTo(input);
    }
}
