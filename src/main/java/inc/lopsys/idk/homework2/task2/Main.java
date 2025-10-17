/**
 * Учитывая массив целых чисел nums и целое число target, верните индексы двух чисел таким образом, чтобы они в сумме равнялись target.
 * Вы можете предположить, что для каждого ввода будет ровно одно решение и что вы не будете использовать один и тот же элемент дважды.
 * Вы можете вернуть ответ в любом порядке.
 */

package inc.lopsys.idk.homework2.task2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Введите элементы массива через пробел: ");
            String inputStr = input.nextLine();
            String[] inputArray = inputStr.split(" ");
            int[] arrayNums = new int[inputArray.length];

            for (int i = 0; i < inputArray.length; i++) {
                if (arrayNums[i] < Math.pow(-10, 9) || arrayNums[i] > Math.pow(10, 9)) {
                    throw new IllegalArgumentException("\nОшибка: Диапазон одного числа от -1000000000 до 1000000000");
                }
                arrayNums[i] = Integer.parseInt(inputArray[i]);
            }

            if (inputArray.length < 2 || inputArray.length > Math.pow(10, 4)) {
                throw new IllegalArgumentException("\nОшибка: Диапазон массива от 2 до 10000");
            }

            System.out.print("Введите цель: ");
            int targetSumArray = input.nextInt();
            if (targetSumArray < Math.pow(-10, 9) || targetSumArray > Math.pow(10, 9)) {
                throw new IllegalArgumentException("\nОшибка: Введите одно целое число. \nДиапазон одного числа от -1000000000 до 1000000000");
            }

            int[] result = findSumArray(arrayNums, targetSumArray);

            System.out.print("Пара найдена: [" + result[0] + ", " + result[1] + "]");

        }
    }

    public static int[] findSumArray(int[] arrayNums, int targetSumArray) {

        HashMap<Integer, Integer> twoNumForSum = new HashMap<>();

        for (int i = 0; i < arrayNums.length; i++) {
            int findNum = targetSumArray - arrayNums[i];

            if (twoNumForSum.containsKey(findNum)) {
                return new int[] { twoNumForSum.get(findNum), i };
            }

            twoNumForSum.put(arrayNums[i], i);
        }


        throw new IllegalArgumentException("Пара не найдена!");

    }
}
