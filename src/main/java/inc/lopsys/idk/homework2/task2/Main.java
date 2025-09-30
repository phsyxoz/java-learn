/**
 * Учитывая массив целых чисел nums и целое число target, верните индексы двух чисел таким образом, чтобы они в сумме равнялись target.
 * Вы можете предположить, что для каждого ввода будет ровно одно решение и что вы не будете использовать один и тот же элемент дважды.
 * Вы можете вернуть ответ в любом порядке.
 */

package inc.lopsys.idk.homework2.task2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            HashMap<Integer, List<Integer>> arrayNums = new HashMap<>();
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
                arrayNums.computeIfAbsent(valueArrayNums, k -> new ArrayList<>()).add(i);
            }

            System.out.print("Введите цель: ");
            int targetSumArray = input.nextInt();
            if (targetSumArray < Math.pow(-10, 9) || targetSumArray > Math.pow(10, 9)) {
                throw new IllegalArgumentException("\nОшибка: Введите одно целое число. \nДиапозон одного числа от -1000000000 до 1000000000");
            }

            findSumArray(arrayNums, targetSumArray);

        }
    }

    public static void findSumArray(HashMap<Integer, List<Integer>> arrayNums, int targetSumArray) {

        for (Integer firstNum : arrayNums.keySet()) {
            int secondNum = targetSumArray - firstNum;

            if (arrayNums.containsKey(secondNum)) {
                List<Integer> index1 = arrayNums.get(firstNum);
                List<Integer> index2 = arrayNums.get(secondNum);

                for (int i : index1) {
                    for (int j : index2) {
                        if (i != j) {
                            System.out.print("Найденная пара: [" + i + ", " + j + "]");
                            return;
                        }
                    }
                }

            }

        }

        System.out.print("Пара не найдена!");

    }
}
