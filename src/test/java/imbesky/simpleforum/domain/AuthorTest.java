package imbesky.simpleforum.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import imbesky.simpleforum.exception.AuthorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorTest {
    @Test
    @DisplayName("유효한 작성자 이름")
    void validAuthor(){
        final String input = "writer";

        final Author author = new Author(input);

        assertThat(author.authorName()).isEqualTo("writer");
    }

    @Test
    @DisplayName("최소 글자 수 이하의 이름")
    void lengthUnderMin(){
        final String input = "wri";

        assertThatThrownBy(()->{new Author(input);}).isInstanceOf(AuthorException.class);
    }

    @Test
    @DisplayName("최대 글자 수 이상의 이름")
    void lengthOverMax(){
        final String input = "writer_is_my_oldest_dream";

        assertThrows(AuthorException.class, () -> {
           new Author(input);
        });
    }
}
