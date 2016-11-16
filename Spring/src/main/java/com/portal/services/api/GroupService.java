package com.portal.services.api;

import com.portal.entities.Group;
import com.portal.entities.User;
import com.portal.exceptions.GroupNotFoundException;
import com.portal.exceptions.UserNotFoundException;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface GroupService extends GenericService<Group, Integer> {
    public Group getGroupByTitle(String title) throws GroupNotFoundException;
}
