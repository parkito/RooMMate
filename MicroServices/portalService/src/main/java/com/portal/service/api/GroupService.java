package com.portal.service.api;

import com.portal.repository.entities.Group;
import com.portal.utils.exceptions.GroupNotFoundException;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface GroupService extends GenericService<Group, Integer> {
    public Group getGroupByTitle(String title) throws GroupNotFoundException;
}
