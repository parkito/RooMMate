package com.portal.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class RoomNotFoundException extends DAOException {
    private static Logger log = LogManager.getLogger();

    /**
     * Exception with message for situation when room wasn't found
     *
     * @param message message for exception
     */
    public RoomNotFoundException(String message) {
        super(message);
        log.warn(message);
    }

    /**
     * exception with message and throwable for situation when room wasn't found
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public RoomNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
        log.warn(message, throwable);

    }
}
