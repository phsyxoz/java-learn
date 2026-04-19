package inc.lopsys.idk.homework3.task3;

public class FaultyConnection implements Connection {
    @Override
    public void execute(String command) throws ConnectionException {
        if (Math.random() < 0.8) {
            throw new ConnectionException("Не удалось выполнить команду: сбой в FaultyConnection");
        }
        else {
            System.out.println("Выполнение команды '" + command + "'");
        }
    }

    @Override
    public void close() {
        System.out.println("Отключено.");
    }
}
