package inc.lopsys.idk.homework4.task5;

import java.util.PriorityQueue;
import java.util.Comparator;

public class StockMarketImpl implements StockMarket {
    private final PriorityQueue<Stock> stockQueue;

    public StockMarketImpl() {

        this.stockQueue = new PriorityQueue<>(Comparator.comparingDouble(Stock::getPrice).reversed());
    }

    @Override
    public void add(Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException("Cannot add null stock");
        }
        stockQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        if (stock == null) {
            return;
        }
        boolean removed = stockQueue.remove(stock);
        if (!removed) {
            System.out.println("Stock not found: " + stock);
        }
    }

    @Override
    public Stock mostValuableStock() {
        return stockQueue.peek();
    }

}
