package inc.lopsys.idk.homework5.task1;

import java.time.Duration;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
            new User ("2022-03-12, 20:20 - 2022-03-12, 23:50"),
            new User ("2022-04-01, 21:30 - 2022-04-02, 01:20"),
            new User ("2023-07-27, 22:01 - 2023-07-27, 23:59")
        );

        Duration avgDuration = calculateAvg(users);
        String formatAvgTime = formatDuration(avgDuration);

        System.out.println("Среднее время посещения: " + formatAvgTime);
    }

    public static Duration calculateAvg(List <User> users) {
        if (users.isEmpty()) {
            return Duration.ZERO;
        }

        long totalSeconds = users.stream()
            .mapToLong(user -> user.getDuration().getSeconds())
            .sum();

        long avgSeconds = totalSeconds / users.size();

        return Duration.ofSeconds(avgSeconds);
    }

    private static String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        return String.format("%dh %dm", hours, minutes);
    }
}
