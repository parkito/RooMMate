package com.portal.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Artem Karnov @date 13.02.2017.
 *         artem.karnov@t-systems.com
 */

public class ResponseEntityException extends RuntimeException {
    private static Logger logger = LogManager.getLogger(ResponseEntityException.class);

    /**
     * Exception with message for situation when something goes wrong with ResponseEntity
     *
     * @param message message for exception
     */
    public ResponseEntityException(String message) {
        super(message);
        logger.warn(message);
    }

    /**
     *Exception with message for situation when something goes wrong with ResponseEntity
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public ResponseEntityException(String message, Throwable throwable) {
        super(message, throwable);
        logger.warn(message, throwable);
    }
}
