package inc.lopsys.idk.homework3.task3;

public class Main {
    public static void  main(String[] args) {
        ConnectionManager defaultManager = new DefaultConnectionManager();
        ConnectionManager faultyManager = new FaultyConnectionManager();

        System.out.printf("ТЕСТ DefaultConnectionManager:%n");
        testExecutor(new PopularCommandExecutor(defaultManager, 5));

        System.out.printf("%nТЕСТ FaultyConnectionManager:%n");
        testExecutor(new PopularCommandExecutor(faultyManager, 5));
    }

    private static void testExecutor(PopularCommandExecutor executor) {
        try {
            executor.updatePackages();
        }
        catch (ConnectionException e) {
            System.out.println("Ошибка: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Причина: " + e.getCause().getMessage());
            }
        }
    }

}
