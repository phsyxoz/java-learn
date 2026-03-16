package inc.lopsys.idk.homework4.task6;

import java.util.TreeMap;
import java.util.Comparator;

public class NullTreeMap<K, V> {
    private final TreeMap<K, V> treeMap;

    public NullTreeMap() {
        this((Comparator<K>) NullComparator.createNullComparator());
    }

    public NullTreeMap(Comparator<K> comparator) {
        this.treeMap = new TreeMap<>(comparator);
    }

    public void add(K key, V value) {
        treeMap.put(key, value);
    }

    public boolean contains(K key) {
        return treeMap.containsKey(key);
    }


    public V get(K key) {
        return treeMap.get(key);
    }

    public V remove(K key) {
        return treeMap.remove(key);
    }

    public int size() {
        return treeMap.size();
    }

    @Override
    public String toString() {
        return treeMap.toString();
    }

    public TreeMap<K, V> getInternalMap() {
        return treeMap;
    }
}
