package pgdp.stream;

public class CheckedStreamException extends RuntimeException{
    public CheckedStreamException() {
    }

    public CheckedStreamException(String message) {
        super(message);
    }

    public CheckedStreamException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedStreamException(Throwable cause) {
        super(cause);
    }

    public CheckedStreamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
