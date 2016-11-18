package com.portal.dao.implementation;

import com.portal.dao.api.UserDAO;
import com.portal.entities.User;
import com.portal.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * @author Artem Karnov @date 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Repository("userDAO")
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByEMAil(String eMail) throws UserNotFoundException {
        try {
            Query query = entityManager.createQuery("select u from User u where u.email=:eMail").
                    setParameter("eMail", eMail);
            return (User) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("User with email " + eMail + " not found!", ex);
        }
    }

}