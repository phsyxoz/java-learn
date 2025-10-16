/**
 * Для заданного целого числа x верните true, если x является палиндромом, и false в противном случае.
 */

package inc.lopsys.idk.homework2.task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {

			System.out.print("Введите целое число: ");
			long number = input.nextLong();
			
            if (number < Math.pow(-2, 31) || number > Math.pow(2, 31) - 1) {
                throw new IllegalArgumentException("\nОшибка, число выходит за диапазон!");
            }
				
            if (isPalindrome(number)) {
                System.out.print("Число является палиндромом!");
            }
            else {
                System.out.print("Число не является палиндромом!");
            }
				
		}

    }
	
	public static boolean isPalindrome(long number) {

        if (number < 0) {
            return false;
        }

		long originalNumber = number;
		long reversedNumber = 0;

        while (number != 0) {
            long lastNumber = number % 10;
            reversedNumber = reversedNumber * 10 + lastNumber;
            number /= 10;
        }
		return originalNumber == reversedNumber;
	}
}
