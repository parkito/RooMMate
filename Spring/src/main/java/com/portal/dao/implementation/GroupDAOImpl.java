package com.portal.dao.implementation;

import com.portal.dao.api.GroupDAO;
import com.portal.entities.Grup;
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
public class GroupDAOImpl extends GenericDAOImpl<Grup, Integer> implements GroupDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Grup getGroupByTitle(String title) {
        try {
            Query query = entityManager.createQuery("select g from Grup g where g.title=:title")
                    .setParameter("title", title);
            return (Grup) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new GroupNotFoundException("Grup " + title + " not found!", ex);
        }
    }
}
