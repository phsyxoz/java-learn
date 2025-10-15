/**
 * Задача 1. Вложенный массив. Напишите программу, которая будет определять, может ли
 * один массив быть вложен во второй. Массив 1 может быть вложен в массив 2, если:
 * Минимальный элемент массива 1 больше, чем минимальный элемент массива 2.
 * Максимальный элемент массива 1 меньше, чем максимальной элемент массива 2.
 * Входные данные: На вход подается два массива элементов типа Integer.
 * Выходные данные: Вывод в консоль true, если первый массив может быть вложен во второй,
 * и false в противном случае.
 */

package inc.lopsys.idk.homework2.task1;

public class Main {

    public static void main(String[] args) {

        Integer[] array1 = {8, 6, 4};
        Integer[] array2 = {1, 100, -200, 5};

        int minNumArray1 = array1[0];
        int maxNumArray1 = array1[0];

        int minNumArray2 = array2[0];
        int maxNumArray2 = array2[0];

        for (int i = 1; i < array1.length; i++) {
            if (array1[i] < minNumArray1) {
                minNumArray1 = array1[i];
            }
            if (array1[i] > maxNumArray1) {
                maxNumArray1 = array1[i];
            }
        }

        for (int i = 1; i < array2.length; i++) {
            if (array2[i] < minNumArray2) {
                minNumArray2 = array2[i];
            }
            if (array2[i] > maxNumArray2) {
                maxNumArray2 = array2[i];
            }
        }

        if (minNumArray1 > minNumArray2 & maxNumArray1 < maxNumArray2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
