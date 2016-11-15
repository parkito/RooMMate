package com.portal.dao.api;

import com.portal.entities.Group;
import com.portal.entities.User;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface UserDAO extends GenericDAO<User, Integer> {
    public User getUserByEMAil(String eMail);
    public void addGroup(User user,Group group);
}
