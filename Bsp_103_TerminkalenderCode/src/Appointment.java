
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Appointment {
  private LocalDateTime dateTime;
  private String text;

    public Appointment(LocalDateTime dateTime, String text) {
        this.dateTime = dateTime;
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%s --> %s",dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy -hh.mm")),text);
    }
  
  
}
