package inc.lopsys.idk.homework3.task3;

public class StableConnection implements Connection {
    @Override
    public void execute(String command) throws ConnectionException {
        System.out.println("Выполнение команды: '" + command + "'");
    }

    @Override
    public void close() {
        System.out.println("Отключено.");
    }
}
