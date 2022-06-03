package pgdp.stream;

public class ErrorsAtTerminalOperationException extends RuntimeException{
    public ErrorsAtTerminalOperationException() {
    }

    public ErrorsAtTerminalOperationException(String message) {
        super(message);
    }

    public ErrorsAtTerminalOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorsAtTerminalOperationException(Throwable cause) {
        super(cause);
    }

    public ErrorsAtTerminalOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
