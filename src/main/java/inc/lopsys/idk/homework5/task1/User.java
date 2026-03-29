package inc.lopsys.idk.homework5.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration duration;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public User(String userTime) {
        parseTime(userTime);
        calculateDuration();
    }

    private void  parseTime (String userTime) {
        String[] timeArray = userTime.split(" - ");
        if (timeArray.length != 2) {
            throw new IllegalArgumentException("Неверный формат промежутка времени!");
        }

        this.startTime = LocalDateTime.parse(timeArray[0].trim().replace(",", ""), formatter);
        this.endTime = LocalDateTime.parse(timeArray[1].trim().replace(",", ""), formatter);

        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("Время окончания сессии раньше начала!");
        }
    }

    private void calculateDuration() {
        this.duration=Duration.between(startTime, endTime);
    }

    public Duration getDuration() {
        return duration;
    }
}
