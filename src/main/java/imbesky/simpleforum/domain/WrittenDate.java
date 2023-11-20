package imbesky.simpleforum.domain;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class WrittenDate {
    private final LocalDate writtenDate;
    public WrittenDate(){
        writtenDate = LocalDate.now();
    }
    public LocalDate initialWrittenDate(){
        return writtenDate;
    }
    public long passedDayUntilNow(){
        return writtenDate.compareTo(LocalDate.now());
    }
}
