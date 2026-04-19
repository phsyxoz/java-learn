/**
 * Дана строка s, содержащая только символы '(', ')', '{', '}', '[' и ']'. Определите, является ли входная строка корректной.
 * Введённая строка действительна, если:
 * Открытые скобки должны быть закрыты скобками того же типа.
 * Открытые скобки должны быть закрыты в правильном порядке.
 * Каждой закрывающей скобке соответствует открывающая скобка того же типа.
 */

package inc.lopsys.idk.homework2.task5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;

public class Main {

    public boolean isValid(String s) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Введите последовательность любых скобок(): ");
            String inputBrackets = input.nextLine();
            int lengthInput = inputBrackets.length();

            HashMap<Character, Character> brackets = new HashMap<>();
            brackets.put(')', '(');
            brackets.put('}', '{');
            brackets.put(']', '[');
            Stack<Character> stack = new Stack<>();

            if (lengthInput > Math.pow(10, 4) || lengthInput < 1) {
                throw new IllegalArgumentException("\nОшибка, неверное количество элементов! (От 1 до 10000)");
            }

            for (char c : inputBrackets.toCharArray()) {
                if (brackets.containsValue(c)) {
                    stack.push(c);
                }
                else if (brackets.containsKey(c)) {
                    if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();

        }
    }
}
