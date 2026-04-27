package inc.lopsys.idk.homework5.task3;

public class Main {
    public static void main(String[] args) {
        System.out.println(DateParser.parseDate("2020-10-10"));     // Optional[2020-10-10]
        System.out.println(DateParser.parseDate("1/3/1976"));       // Optional[1976-03-01]
        System.out.println(DateParser.parseDate("tomorrow"));       // Optional[<завтрашняя дата>]
        System.out.println(DateParser.parseDate("yesterday"));      // Optional[<вчерашняя дата>]
        System.out.println(DateParser.parseDate("1 day ago"));      // Optional[<дата 1 день назад>]
        System.out.println(DateParser.parseDate("2234 days ago"));  // Optional[<дата 2234 дня назад>]
        System.out.println(DateParser.parseDate("invalid date"));   // Optional.empty
    }
}
