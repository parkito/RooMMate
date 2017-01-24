package com.portal.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Artem Karnov @date 23.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class EntityAlreadyExistsException extends DAOException {
    private static Logger logger = LogManager.getLogger(EntityAlreadyExistsException.class);

    /**
     * Exception with message for situation when group entity already exists
     *
     * @param message message for exception
     */
    public EntityAlreadyExistsException(String message) {
        super(message);
        logger.warn(message);
    }

    /**
     * exception with message and throwable for situation when entity already exists
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public EntityAlreadyExistsException(String message, Throwable throwable) {
        super(message, throwable);
        logger.warn(message, throwable);
    }
}