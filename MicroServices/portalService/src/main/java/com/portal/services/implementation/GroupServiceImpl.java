package com.portal.services.implementation;

import com.portal.dao.api.GroupDAO;
import com.portal.entities.Grup;
import com.portal.exceptions.DAOException;
import com.portal.exceptions.EntityAlreadyExistsException;
import com.portal.exceptions.GroupNotFoundException;
import com.portal.exceptions.UserNotFoundException;
import com.portal.services.api.GroupService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Artem Karnov @date 16.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Service("groupService")
public class GroupServiceImpl implements GroupService {
    private static Logger logger = LogManager.getLogger(GroupServiceImpl.class);

    @Autowired
    private GroupDAO groupDAO;

    @Override
    @Transactional
    public void createEntity(Grup grup) throws DAOException {
        if (!isGroupExists(grup)) {
            groupDAO.create(grup);
            logger.info("Group " + grup + "was successfully created");
        } else {
            throw new EntityAlreadyExistsException("Group " + grup.getTitle() + " already exists");
        }
    }

    /**
     * Get group entity by id
     *
     * @param id id for getting
     * @return group with adjusted id
     * @throws DAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public Grup getEntityById(Integer id) throws DAOException {
        return groupDAO.read(id);
    }

    /**
     * Update group entity in base
     *
     * @param entity entity for updating
     * @throws DAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void updateEntity(Grup entity) throws DAOException {
        groupDAO.update(entity);
    }

    /**
     * Delete group entity from base
     *
     * @param entity entity for deleting
     * @throws DAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void deleteEntity(Grup entity) throws DAOException {
        groupDAO.delete(entity);
    }

    /**
     * Getting all group entities from base
     *
     * @return list of all groups
     * @throws DAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public List<Grup> getAll() throws DAOException {
        return groupDAO.getAll();
    }

    /**
     * Getting group entity by email
     *
     * @param title entity for getting
     * @return group with adjusted email
     * @throws UserNotFoundException if group not found
     */
    @Override
    @Transactional
    public Grup getGroupByTitle(String title) throws GroupNotFoundException {
        return groupDAO.getGroupByTitle(title);
    }

    /**
     * Checking grup existing in base
     *
     * @param grup entity for checking
     * @return true - if grup exists, false if doesn't
     */
    public boolean isGroupExists(Grup grup) {
        try {
            return getGroupByTitle(grup.getTitle()) != null ? true : false;
        } catch (GroupNotFoundException ex) {
            logger.warn("Group " + grup + "isn't exist");
            return false;
        }
    }

}