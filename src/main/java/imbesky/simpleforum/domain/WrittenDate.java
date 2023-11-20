package imbesky.simpleforum.domain;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.format.datetime.DateFormatter;

@Embeddable
public class WrittenDate {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
    private final LocalDateTime writtenDate;
    public WrittenDate(){
        writtenDate = LocalDateTime.now();
    }
    public String  initialWrittenDate(){
        return writtenDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
    public long passedDayUntilNow(){
        return writtenDate.compareTo(LocalDateTime.now());
    }
}
