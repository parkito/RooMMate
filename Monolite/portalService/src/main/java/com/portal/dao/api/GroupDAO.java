package com.portal.dao.api;

import com.portal.entities.Grup;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface GroupDAO extends GenericDAO<Grup, Integer> {
    public Grup getGroupByTitle(String title);
}

