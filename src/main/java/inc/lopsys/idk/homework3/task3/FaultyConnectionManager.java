package inc.lopsys.idk.homework3.task3;

public class FaultyConnectionManager implements ConnectionManager{
    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
