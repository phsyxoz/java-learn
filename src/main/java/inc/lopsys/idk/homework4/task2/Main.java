/**
 * Частота слов
 * На вход подаётся список объектов одного типа. Верните частотный словарь этого списка.
 */

package inc.lopsys.idk.homework4.task2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> objects = Arrays.asList("this", "and", "that", "and");
        Map<String, Long> freq = FreqCount.getFreqMap(objects);
        System.out.println(freq);
    }

    public class FreqCount {
        public static <T> Map<T, Long> getFreqMap(List<T> list) {
            return list.stream()
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                ));
        }
    }
}
