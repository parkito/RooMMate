package com.portal.exceptions;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class DAOException extends RuntimeException {
    /**
     * Exception with message for situation when something goes wrong on DAO
     *
     * @param message message for exception
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when something goes wrong on DAO
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public DAOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}