package inc.lopsys.idk.homework6.task1;

public class Main {
    public static void main(String[] args) {
        DiskMap map = new DiskMap("data.txt");

        map.put("name", "Даниил");
        map.put("age", "23");

        System.out.println(map.get("name"));
    }
}
