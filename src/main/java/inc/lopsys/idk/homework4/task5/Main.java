package inc.lopsys.idk.homework4.task5;

public class Main {
    public static void  main(String[] args) {
        StockMarket market = new StockMarketImpl();

        Stock apple = new Stock("Apple", 150);
        Stock samsung = new Stock("Samsung", 100);
        Stock xiaomi = new Stock("Xiaomi", 75);

        market.add(apple);
        market.add(samsung);
        market.add(xiaomi);

        System.out.println("Самая дорогая акция: " + market.mostValuableStock());
    }
}
