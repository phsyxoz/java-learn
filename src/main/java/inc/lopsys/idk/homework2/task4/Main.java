/**
 * Напишите функцию для поиска самого длинного общего префикса в массиве строк.
 * Если общего префикса нет, верните пустую строку "".
 */

package inc.lopsys.idk.homework2.task4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String main (String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Введите слова через пробел (Строчными буквами, без цифр): ");
            String inputWordsArray = input.nextLine();
            String[] wordsArray = inputWordsArray.split(" ");

            if (wordsArray.length == 1) {
                return wordsArray[0];
            }

            if (wordsArray.length > 200 || wordsArray.length < 1) {
                throw new IllegalArgumentException("\nОшибка, неверное количество слов! (От 1 до 200)");
            }

            ArrayList<String> wordsList = new ArrayList<>();
            int lengthWordList = 200;

            for (String word : wordsArray) {

                for (char correctWord : word.toCharArray()) {
                    if (Character.isDigit(correctWord) || Character.isUpperCase(correctWord)) {
                        throw new IllegalArgumentException("\nОшибка, в словах имеются заглавные буквы или цифры!");
                    }
                }

                if (word.length() > 200) {
                    throw new IllegalArgumentException("\nОшибка, неверная длина слова! (От 0 до 200)");
                }
                else if (word.length() < lengthWordList) {
                    lengthWordList = word.length();
                }

                if (lengthWordList == 0) {
                    return "";
                }

                wordsList.add(word);

            }

            ArrayList<Character> firstPrefixList = new ArrayList<>();
            String firstWordList = wordsList.getFirst();

            for (int i = 0; i < lengthWordList; i++) {
                char letter = firstWordList.charAt(i);
                firstPrefixList.add(letter);
            }

            StringBuilder prefix = new StringBuilder();
            ArrayList<Character> nextPrefixList = new ArrayList<>();
            int lengthPrefix = firstPrefixList.size();
            for (int j = 1; j < wordsList.size(); j++) {

                String nextWordPrefix = wordsList.get(j);
                for (int i = 0; i < lengthPrefix; i++) {
                    char letter = nextWordPrefix.charAt(i);
                    nextPrefixList.add(letter);
                }

                prefix.setLength(0);
                for (int w = 0; w < lengthPrefix; w++){
                    if (!firstPrefixList.get(w).equals(nextPrefixList.get(w))) {
                        break;
                    }
                    prefix.append(firstPrefixList.get(w));
                }
                nextPrefixList.clear();
                lengthPrefix = prefix.length();
            }

            return prefix.toString();

        }

    }

}
