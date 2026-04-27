package inc.lopsys.idk.homework5.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchDate {

    public static List<LocalDate> searchDate(int year) {

        return Stream.of(Month.values())
            .map(month -> LocalDate.of(year, month , 13))
            .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY)
            .collect(Collectors.toList());
    }

    public static LocalDate findNextFriday13() {
        LocalDate current = LocalDate.now();
        LocalDate candidate = current.withDayOfMonth(13);

        if (candidate.isBefore(current)) {
            candidate = candidate.plusMonths(1);
        }

        while (candidate.getDayOfWeek() != DayOfWeek.FRIDAY) {
            candidate = candidate.plusMonths(1);
        }
        return candidate;
    }
}
