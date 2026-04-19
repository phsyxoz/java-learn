package inc.lopsys.idk.homework3.task3;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return Math.random() > 0.3
            ? new FaultyConnection()
            : new StableConnection();
    }
}
