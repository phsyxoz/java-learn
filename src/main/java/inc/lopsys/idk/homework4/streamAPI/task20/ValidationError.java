package inc.lopsys.idk.homework4.streamAPI.task20;

public class ValidationError {
    private final String message;

    public ValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
