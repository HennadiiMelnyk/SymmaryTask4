package ua.nure.melnyk.SummaryTask4.exceptions;

/**
 * Database Exception
 *
 *
 *
 */
public class DBException extends CustomException {
    private static final long serialVersionUID = -4902841828417039172L;
    public DBException() {
        super();
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
