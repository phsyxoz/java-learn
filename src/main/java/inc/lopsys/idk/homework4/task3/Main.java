/**
 * Римские цифры
 * Создать функцию, которая принимает арабское число и преобразует его в римское.
 */

package inc.lopsys.idk.homework4.task3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число (от 1 до 4999): ");
        try {
            int input = scanner.nextInt();

            if (input < 1 || input > 4999) {
                System.out.println("Ошибка: число в диапазоне от 1 до 4999.");
            }
            else {
                String roman = convertToRoman(input);
                System.out.println("Римское число " + input + " — " + roman);
            }

        }
        catch (Exception e) {
            System.out.println("Ошибка: введите корректное целое число.");
        }
    }

    public static String convertToRoman(int number) {

        if (number < 1 || number > 4999) {
            throw new RuntimeException("Число в диапазоне от 1 до 4999");
        }

        Map<Integer, String> romanNum = new LinkedHashMap<>();

        romanNum.put(1000, "M");
        romanNum.put(900,  "CM");
        romanNum.put(500,  "D");
        romanNum.put(400,  "CD");
        romanNum.put(100,  "C");
        romanNum.put(90,   "XC");
        romanNum.put(50,   "L");
        romanNum.put(40,   "XL");
        romanNum.put(10,   "X");
        romanNum.put(9,    "IX");
        romanNum.put(5,    "V");
        romanNum.put(4,    "IV");
        romanNum.put(1,    "I");

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanNum.entrySet()) {
            int value = entry.getKey();
            String numeral = entry.getValue();

            while (number >= value) {
                result.append(numeral);
                number -= value;
            }
        }

        return result.toString();
    }
}
