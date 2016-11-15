package com.portal.services.api;

import com.portal.entities.User;
import com.portal.exceptions.UserNotFoundException;

/**
 * @author Artem Karnov @date 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface UserService extends GenericService<User, Integer> {

    /**
     * Getting user entity by email
     *
     * @param eMail entity for getting
     * @return user with adjusted email
     * @throws UserNotFoundException if user not found
     */
    public User getUserByEMAil(String eMail) throws UserNotFoundException;

}