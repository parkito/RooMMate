package com.portal.dao.implementation;

import com.portal.dao.api.GroupDAO;
import com.portal.dao.api.UserDAO;
import com.portal.entities.Group;
import com.portal.entities.User;
import com.portal.exceptions.UserNotFoundException;
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
    public User getGroupByTitle(String title) {
        try {
            Query query = entityManager.createQuery("select u from Groups u where u.title=:title")
                    .setParameter("title", title);
            return (User) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("Group " + title + " not found!", ex);
        }
    }
}
