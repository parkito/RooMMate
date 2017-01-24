package com.portal.exceptions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class GroupNotFoundException extends DAOException {
    private static Logger logger = LogManager.getLogger(GroupNotFoundException.class);

    /**
     * Exception with message for situation when group wasn't found
     *
     * @param message message for exception
     */
    public GroupNotFoundException(String message) {
        super(message);
        logger.warn(message);
    }

    /**
     * exception with message and throwable for situation when group wasn't found
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public GroupNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
        logger.warn(message, throwable);
    }
}