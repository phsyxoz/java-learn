package inc.lopsys.idk.homework3.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        if (maxAttempts <= 0) {
            throw new RuntimeException("Количество попыток должно быть больше 0");
        }

        if (manager == null) {
            throw new RuntimeException("Менеджер не может быть пустым");
        }
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void tryExecute(String command) throws ConnectionException {
        Exception lastException = null;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            Connection connection = null;

            try {
                connection = manager.getConnection();
                String connType = (connection instanceof StableConnection)
                    ? "Стабильное"
                    : "Проблемное";

                System.out.printf("Попытка %d: Подключение: %s (%s)%n",
                    attempt, connection.getClass().getSimpleName(), connType);

                connection.execute(command);
                System.out.println("Команда успешно выполнена.");
                return;
            }
            catch (ConnectionException e) {
                lastException = e;
                System.err.printf("Попытка %d: %s%n", attempt, e.getMessage());
            }
            catch (Exception e) {
                lastException = e;
                System.err.printf("Непредвиденная ошибка: %s%n", e.getMessage());
            }
            finally {
                if (connection != null) {
                    try {
                        connection.close();
                    }
                    catch (Exception e) {
                        System.err.println("Ошибка при отключении: " + e.getMessage());
                    }
                }
            }
        }

        throw new ConnectionException(String.format("Не удалось выполнить команду за %d попыток", maxAttempts), lastException);

    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }
}
