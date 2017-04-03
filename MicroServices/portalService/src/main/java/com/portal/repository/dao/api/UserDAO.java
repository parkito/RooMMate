package com.portal.repository.dao.api;

import com.portal.repository.entities.User;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface UserDAO extends GenericDAO<User, Integer> {
    public User getUserByEMAil(String eMail);
}
