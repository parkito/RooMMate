package com.portal.exceptions;

/**
 * @author Artem Karnov @date 23.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class EntityAlreadyExistsException extends DAOException {
        /**
         * Exception with message for situation when group entity already exists
         *
         * @param message message for exception
         */
        public EntityAlreadyExistsException(String message) {
            super(message);
        }

        /**
         * exception with message and throwable for situation when entity already exists
         *
         * @param message   message for exception
         * @param throwable object for exception
         */
        public EntityAlreadyExistsException(String message, Throwable throwable) {
            super(message, throwable);
        }
    }