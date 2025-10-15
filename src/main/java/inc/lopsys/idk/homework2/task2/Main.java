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

            HashMap<Integer, Integer> arrayNums = new HashMap<>();
            System.out.print("Введите размер массива: ");
            int sizeArrayNums = input.nextInt();

            if (sizeArrayNums < 2 || sizeArrayNums > Math.pow(10, 4)) {
                throw new IllegalArgumentException("\nОшибка: Введите одно целое число. \nДиапозон одного числа от 2 до 10000");
            }

            System.out.print("Введите элементы массива: ");
            for (int i = 0; i < sizeArrayNums; i++) {
                int valueArrayNums = input.nextInt();
                if (valueArrayNums < Math.pow(-10, 9) || valueArrayNums > Math.pow(10, 9)) {
                    throw new IllegalArgumentException("\nОшибка: Введите целые числа. \nДиапозон одного числа от -1000000000 до 1000000000");
                }
                arrayNums.put(valueArrayNums, i);
            }

            System.out.print("Введите цель: ");
            int targetSumArray = input.nextInt();
            if (targetSumArray < Math.pow(-10, 9) || targetSumArray > Math.pow(10, 9)) {
                throw new IllegalArgumentException("\nОшибка: Введите одно целое число. \nДиапозон одного числа от -1000000000 до 1000000000");
            }

            int[] result = findSumArray(arrayNums, targetSumArray);

            System.out.print("Пара найдена: [" + result[0] + ", " + result[1] + "]");

        }
    }

    public static int[] findSumArray(HashMap<Integer, Integer> arrayNums, int targetSumArray) {

        for (Integer firstNum : arrayNums.keySet()) {
            int findNum = targetSumArray - firstNum;

            for (int i = 0; i < arrayNums.size(); i++) {

                if (arrayNums.containsKey(findNum)) {
                    return new int[] { arrayNums.get(findNum), i };
                }
            }
        }

        throw new IllegalArgumentException("Пара не найдена!");

    }
}
