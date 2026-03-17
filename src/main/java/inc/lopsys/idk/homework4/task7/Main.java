package inc.lopsys.idk.homework4.task7;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        BackwardIterator<Integer> backIter = new BackwardIterator<>(list);

        System.out.println("List: " + list);
        System.out.print("Backward Iterator: ");

        while (backIter.hasNext()) {
            System.out.print(backIter.next() + " ");
        }
    }
}
