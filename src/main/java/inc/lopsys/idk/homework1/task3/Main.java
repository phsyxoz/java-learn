package inc.lopsys.idk.homework1.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)){
            System.out.print("Введите положительное целое число: ");
            long positiveNumber = input.nextLong();
            int  count = 0;

                if (positiveNumber < 0 || positiveNumber == 0) {
                    throw new InputMismatchException();
                }
                else {

                    for (long temp = positiveNumber; temp > 0; temp /= 10) {
                        count++;
                    }

                }

            System.out.println("Количество цифр: " + count);
        }
        catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите положительное целое число!");
        }

    }
}