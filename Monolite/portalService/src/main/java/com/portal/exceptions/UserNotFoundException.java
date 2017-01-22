package com.portal.exceptions;

import org.apache.log4j.Logger;

/**
 * @author Artem Karnov @date 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class UserNotFoundException extends DAOException {
    private static final Logger log = Logger.getLogger(GroupNotFoundException.class);

    /**
     * Exception with message for situation when user wasn't found
     *
     * @param message message for exception
     */
    public UserNotFoundException(String message) {
        super(message);
        log.warn(message);
    }

    /**
     * exception with message and throwable for situation when user wasn't found
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public UserNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
        log.warn(message, throwable);
    }
}
