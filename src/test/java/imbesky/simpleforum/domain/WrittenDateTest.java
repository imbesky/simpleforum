package imbesky.simpleforum.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WrittenDateTest {
    @Test
    @DisplayName("날짜 형식 테스트")
    void writtenDateFormat(){
        final WrittenDate writtenDate = new WrittenDate();
        final LocalDateTime localDateTime = LocalDateTime.now();
        final String format = "%d-%d-%d %d:%d";

        assertThat(writtenDate.initialWrittenDate()).isEqualTo(String.format(format,localDateTime.getYear(),localDateTime.getMonth().getValue(),localDateTime.getDayOfMonth(),localDateTime.getHour(),localDateTime.getMinute()));
    }
}
