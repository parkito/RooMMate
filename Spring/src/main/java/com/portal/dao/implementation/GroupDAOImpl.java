package com.portal.dao.implementation;

import com.portal.dao.api.GroupDAO;
import com.portal.entities.Group;
import com.portal.exceptions.GroupNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Repository("groupDAO")
public class GroupDAOImpl extends GenericDAOImpl<Group, Integer> implements GroupDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Group getGroupByTitle(String title) {
        try {
            Query query = entityManager.createQuery("select g from Group g where g.Title=:title")
                    .setParameter("title", title);
            return (Group) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new GroupNotFoundException("Group " + title + " not found!", ex);
        }
    }
}
