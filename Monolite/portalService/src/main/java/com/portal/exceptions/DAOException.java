package com.portal.exceptions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class DAOException extends RuntimeException {
    private static Logger log = LogManager.getLogger();

    /**
     * Exception with message for situation when something goes wrong on DAO
     *
     * @param message message for exception
     */
    public DAOException(String message) {
        super(message);
        log.warn(message);
    }

    /**
     * exception with message and throwable for situation when something goes wrong on DAO
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public DAOException(String message, Throwable throwable) {
        super(message, throwable);
        log.warn(message, throwable);
    }
}