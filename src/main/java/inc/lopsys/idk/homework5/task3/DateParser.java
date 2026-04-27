package inc.lopsys.idk.homework5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.regex.Pattern;

public class DateParser {
    public static Optional<LocalDate> parseDate(String string) {
        if (string == null || string.trim().isEmpty()) {
            return Optional.empty();
        }

        string = string.trim();

        try {
            if (Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2}", string)) {
                return Optional.of(LocalDate.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            } else if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{4}", string)) {
                return Optional.of(LocalDate.parse(string, DateTimeFormatter.ofPattern("d/M/yyyy")));
            } else if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{2}", string)) {
                String[] parts = string.split("/");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int yearShort = Integer.parseInt(parts[2]);

                int year = yearShort < 50 ? yearShort + 2000 : yearShort + 1900;
                return Optional.of(LocalDate.of(year, month, day));
            }
        } catch (DateTimeParseException e) {

        }

        LocalDate today = LocalDate.now();
        switch (string.toLowerCase()) {
            case "today":
                return Optional.of(today);
            case "tomorrow":
                return Optional.of(today.plusDays(1));
            case "yesterday":
                return Optional.of(today.minusDays(1));
            default:
                break;
        }

        if (string.endsWith(" days ago") || string.endsWith(" day ago")) {
            try {
                String daysStr = string.replaceAll("\\s*\\b(day|days)\\s+ago\\b", "");
                daysStr = daysStr.trim();
                long daysAgo = Long.parseLong(daysStr);
                return Optional.of(today.minusDays(daysAgo));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }
}
