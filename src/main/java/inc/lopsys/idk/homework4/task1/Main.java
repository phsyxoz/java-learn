/**
 * Шифр Атбаш
 * Замечания:
 * - используется латинский алфавит
 * - регистр букв нужно сохранить
 * - символы не латинского алфавита нужно писать как есть
 */

package inc.lopsys.idk.homework4.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования Атбаш:");
        String input = scanner.nextLine();

        String result = atbash(input);
        System.out.println("Зашифрованный текст: " + result);

        scanner.close();
    }

    public static String atbash(String message) {
        StringBuilder code = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch) && checkLetters(ch)) {
                boolean isUpperCase = Character.isUpperCase(ch);
                char upperChar = Character.toUpperCase(ch);
                char replaceLetter = (char) ('Z' - (upperChar - 'A'));
                code.append(isUpperCase ? replaceLetter : Character.toLowerCase(replaceLetter));
            } else {
                code.append(ch);
            }
        }

        return code.toString();
    }

    private static boolean checkLetters(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

}
