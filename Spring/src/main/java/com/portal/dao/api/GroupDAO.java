package com.portal.dao.api;

import com.portal.entities.Group;
import com.portal.entities.User;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface GroupDAO extends GenericDAO<Group, Integer> {
        public Group getGroupByTitle(String title);
    }

