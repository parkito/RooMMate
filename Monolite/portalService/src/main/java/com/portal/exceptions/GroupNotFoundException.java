package com.portal.exceptions;

import org.apache.log4j.Logger;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class GroupNotFoundException extends DAOException {
    private static final Logger log = Logger.getLogger(GroupNotFoundException.class);

    /**
     * Exception with message for situation when group wasn't found
     *
     * @param message message for exception
     */
    public GroupNotFoundException(String message) {
        super(message);
        log.warn(message);
    }

    /**
     * exception with message and throwable for situation when group wasn't found
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public GroupNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
        log.warn(message, throwable);
    }
}
