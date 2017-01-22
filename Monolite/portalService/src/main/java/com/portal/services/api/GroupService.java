package com.portal.services.api;

import com.portal.entities.Grup;
import com.portal.exceptions.GroupNotFoundException;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface GroupService extends GenericService<Grup, Integer> {
    public Grup getGroupByTitle(String title) throws GroupNotFoundException;
}
