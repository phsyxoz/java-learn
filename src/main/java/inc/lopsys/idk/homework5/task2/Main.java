package inc.lopsys.idk.homework5.task2;

import java.time.LocalDate;
import java.util.List;

public class Main {

    static public void main(String[] args) {

        int needYear = 2026;

        List<LocalDate> result = SearchDate.searchDate(needYear);
        LocalDate nextFriday13 = SearchDate.findNextFriday13();

        System.out.println("Все пятницы 13-е в " + needYear + " году: \n" + result);
        System.out.println("Ближайшая пятница 13-е: " + nextFriday13);
    }
}
