package ua.nure.melnyk.SummaryTask4.exceptions;

/**
 * Main class of exceptions
 *
 *
 *
 */
public class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
    private static final long serialVersionUID = 8288779062647218916L;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }
}
