package inc.lopsys.idk.homework4.task6;

import java.util.Comparator;

public class NullComparator {

    public static <T extends Comparable<T>> Comparator<T> createNullComparator() {
        return Comparator.nullsFirst(Comparator.naturalOrder());
    }

    public static <T> Comparator<T> createNullComparator(Comparator<T> baseComparator) {
        return Comparator.nullsFirst(baseComparator);
    }
}
