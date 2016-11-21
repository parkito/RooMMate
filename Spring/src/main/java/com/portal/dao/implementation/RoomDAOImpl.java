package com.portal.dao.implementation;

import com.portal.dao.api.RoomDAO;
import com.portal.entities.Room;
import com.portal.exceptions.RoomNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Repository("roomDAO")
public class RoomDAOImpl extends GenericDAOImpl<Room, Integer> implements RoomDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Room getRoomByTitle(String title) {
        try {
            Query query = entityManager.createQuery("select r from Room r where r.title=:title")
                    .setParameter("title", title);
            return (Room) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new RoomNotFoundException("Grup " + title + " not found!", ex);
        }
    }
}