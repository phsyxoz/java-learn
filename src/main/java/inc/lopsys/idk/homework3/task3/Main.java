package inc.lopsys.idk.homework3.task3;

//Удаленный сервер. Программист Иван хочет выполнять часто используемые
//консольные команды на удаленном сервере из Java-программы. В распоряжении Ивана
//следующий набор интерфейсов:
//Помогите Ивану и реализуйте:
//    2 типа соединений: StableConnection/FaultyConnection, стабильное соединение работает всегда, проблемное соединение иногда бросает ConnectionException
//    DefaultConnectionManager, который с некоторой вероятностью возвращает проблемное соединение FaultyConnectionManager, который всегда возвращает проблемное соединение
//    Метод tryExecute(...), который должен попытаться выполнить переданную команду maxAttempts раз
//    Если tryExecute не смог выполнить команду (превышено количество попыток), то нужно вернуть ConnectionException, при этом сохранив оригинальное исключение в параметре cause
//    Обратите внимание, что Connection требуется закрывать ( интерфейс AutoCloseable )

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
