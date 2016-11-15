package com.portal.exceptions;

/**
 * @author Artem Karnov @date 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class UserNotFoundException extends CustomDAOException {
    /**
     * Exception with message for situation when user wasn't found
     *
     * @param message message for exception
     */
    public UserNotFoundException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when user wasn't found
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public UserNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
