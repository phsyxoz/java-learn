package inc.lopsys.idk.homework3.task3;

public interface Connection extends AutoCloseable {
    void execute(String command) throws ConnectionException;
}

