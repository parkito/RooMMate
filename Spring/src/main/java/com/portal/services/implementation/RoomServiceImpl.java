package com.portal.services.implementation;

import com.portal.dao.api.RoomDAO;
import com.portal.entities.Room;
import com.portal.exceptions.CustomDAOException;
import com.portal.exceptions.RoomNotFoundException;
import com.portal.exceptions.UserNotFoundException;
import com.portal.services.api.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDAO roomDAO;


    @Override
    @Transactional
    public void createEntity(Room room) throws CustomDAOException {
        if (!isRoomExists(room)) {
            roomDAO.create(room);
        }
    }

    /**
     * Get room entity by id
     *
     * @param id id for getting
     * @return room with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public Room getEntityById(Integer id) throws CustomDAOException {
        return roomDAO.read(id);
    }

    /**
     * Update room entity in base
     *
     * @param entity entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void updateEntity(Room entity) throws CustomDAOException {
        roomDAO.update(entity);
    }

    /**
     * Delete room entity from base
     *
     * @param entity entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void deleteEntity(Room entity) throws CustomDAOException {
        roomDAO.delete(entity);
    }

    /**
     * Getting all room entities from base
     *
     * @return list of all rooms
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public List<Room> getAll() throws CustomDAOException {
        return roomDAO.getAll();

    }

    /**
     * Getting room entity by email
     *
     * @param title entity for getting
     * @return room with adjusted email
     * @throws RoomNotFoundException if room not found
     */
    @Override
    @Transactional
    public Room getRoomByTitle(String title) throws RoomNotFoundException {
        return roomDAO.getRoomByTitle(title);
    }

    /**
     * Checking room existing in base
     *
     * @param room entity for checking
     * @return true - if room exists, false if doesn't
     */
    public boolean isRoomExists(Room room) {
        try {
            return getRoomByTitle(room.getTitle()) != null ? true : false;
        } catch (RoomNotFoundException ex) {
            return false;
        }
    }

}
