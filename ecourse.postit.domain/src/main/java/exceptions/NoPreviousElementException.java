package exceptions;

/**
 * The type No previous element exception.
 * Useful when searching for the previous element in a history, but there is none.
 */
public class NoPreviousElementException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "No previous element";

    /**
     * Instantiates a new No previous element exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NoPreviousElementException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new No previous element exception.
     *
     * @param cause the cause
     */
    public NoPreviousElementException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new No previous element exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public NoPreviousElementException(String message,
                                      Throwable cause,
                                      boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new No previous element exception.
     */
    public NoPreviousElementException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Instantiates a new No previous element exception.
     *
     * @param message the message
     */
    public NoPreviousElementException(String message) {
        super(message);
    }

}
