package inc.lopsys.idk.homework4.task5;

public interface StockMarket {
    /** Добавить акцию */
    void add(Stock stock);
    /** Удалить акцию */
    void remove(Stock stock);
    /** Самая дорогая акция */
    Stock mostValuableStock();
}
