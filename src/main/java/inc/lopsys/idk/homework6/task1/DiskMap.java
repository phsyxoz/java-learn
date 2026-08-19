package inc.lopsys.idk.homework6.task1;

import java.io.*;
import java.util.*;

public class DiskMap implements Map<String, String> {

    private String filePath;
    private Map<String, String> internalMap = new HashMap<>();

    public DiskMap(String filePath) {
        this.filePath = filePath;
        loadFromFile();
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(":")) {
                    String[] parts = line.split(":", 2);
                    internalMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            if (!new File(filePath).exists()) {
                try {
                    new File(filePath).createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                e.printStackTrace();
            }
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : internalMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return internalMap.size();
    }

    @Override
    public boolean isEmpty() {
        return internalMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return internalMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return internalMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public String put(String key, String value) {
        String oldValue = internalMap.put(key, value);
        saveToFile();
        return oldValue;
    }

    @Override
    public String remove(Object key) {
        String removedValue = internalMap.remove(key);
        saveToFile();
        return removedValue;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        internalMap.putAll(m);
        saveToFile();
    }

    @Override
    public void clear() {
        internalMap.clear();
        saveToFile();
    }

    @Override
    public Set<String> keySet() {
        return internalMap.keySet();
    }

    @Override
    public Collection<String> values() {
        return internalMap.values();
    }

    @Override
    public Set<Map.Entry<String, String>> entrySet() {
        return internalMap.entrySet();
    }
}
