package com.portal.exceptions;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class GroupNotFoundException extends DAOException {
    /**
     * Exception with message for situation when group wasn't found
     *
     * @param message message for exception
     */
    public GroupNotFoundException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when group wasn't found
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public GroupNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
