package com.portal.dao.implementation;

import com.portal.dao.api.GroupDAO;
import com.portal.entities.Group;
import com.portal.exceptions.GroupNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static Logger logger = LogManager.getLogger(GroupDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @param title title of group for getting
     * @return group that was gotten
     */
    @Override
    public Group getGroupByTitle(String title) {
        try {
            Query query = entityManager.createQuery("select g from Group g where g.title=:title")
                    .setParameter("title", title);
            logger.info("Group " + title + " was successfully read");
            return (Group) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new GroupNotFoundException("Grup " + title + " wasn't found!", ex);
        }
    }
}
