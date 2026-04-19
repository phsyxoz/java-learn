package inc.lopsys.idk.homework4.task6;

import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class Main {
    public static void main(String[] args) {
        NullTreeMap<String, String> tree = new NullTreeMap<>();

        tree.add(null, "test");
        assertThat(tree.contains(null)).isTrue();

        System.out.println("TreeMap: " + tree);

    }
}
