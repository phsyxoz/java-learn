package inc.lopsys.idk.homework5.task7;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] testStrings = {"000", "101", "010", "111", "001", "1", "01", "100"};

        String regex1 = "..0.*";
        String regex2 = "^(0.*0|1.*1)$";
        String regex3 = "^[0,1]{1,3}$";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);

        Arrays.stream(testStrings)
            .forEach(str -> {
            Matcher matcher1 = pattern1.matcher(str);
            Matcher matcher2 = pattern2.matcher(str);
            Matcher matcher3 = pattern3.matcher(str);

            System.out.println("Строка: " + str);
            System.out.println("Условие 1 (третий символ 0): " + matcher1.matches());
            System.out.println("Условие 2 (одинаковые первый и последний символы): " + matcher2.matches());
            System.out.println("Условие 3 (длина 1–3): " + matcher3.matches());
            System.out.println("---");
        });
    }
}
