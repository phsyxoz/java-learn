package inc.lopsys.idk.homework5.task8;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String[] testStrings = {"0", "1", "01", "10", "010", "101", "000", "111", "0110", "1001", "0010"};

        Pattern oddLength = Pattern.compile("(0|1)((0|1)(0|1))*");
        checkPattern(oddLength, "Нечётной длины", testStrings);

        Pattern startsWith0OddOr1Even = Pattern.compile("0((0|1)(0|1))*|1((0|1)(0|1))*");
        checkPattern(startsWith0OddOr1Even, "Начинается с 0 (нечётная длина) или с 1 (чётная длина)", testStrings);

        Pattern zerosMultipleOf3 = Pattern.compile("(1*01*01*01*)*");
        checkPattern(zerosMultipleOf3, "Количество 0 кратно 3", testStrings);

        Pattern not11Or111 = Pattern.compile("^(?!11|111).*");
        checkPattern(not11Or111, "Любая строка, кроме '11' или '111'", testStrings);

        Pattern oddPositionsAre1 = Pattern.compile("^(1(0|1)?)*$");
        checkPattern(oddPositionsAre1, "Каждый нечётный символ равен 1", testStrings);

        Pattern atLeastTwoZerosOneOne = Pattern.compile("(00(0|1?)*)|(0(0|1?)*0)");
        checkPattern(atLeastTwoZerosOneOne, "Содержит ≥2 нулей и ≤1 единицы", testStrings);

        Pattern noConsecutiveOnes = Pattern.compile("(0|10)*(0|1?)?");
        checkPattern(noConsecutiveOnes, "Нет последовательных единиц", testStrings);
    }

    private static void checkPattern(Pattern pattern, String description, String[] testStrings) {
        System.out.println("\nПроверка: " + description);

        Arrays.stream(testStrings)
            .map(str -> {
                Matcher matcher = pattern.matcher(str);
                return str + " -> " + matcher.matches();
            })
            .forEach(System.out::println);

        System.out.println("-".repeat(50));
    }
}
