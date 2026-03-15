/**
 * Римские цифры
 * Создать функцию, которая принимает арабское число и преобразует его в римское.
 */

package inc.lopsys.idk.homework4.task3;

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

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                result.append(numerals[i]);
                number -= values[i];
            }
        }

        return result.toString();
    }
}
