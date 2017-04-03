package com.portal.service.api;

import com.portal.utils.exceptions.DAOException;

import java.util.List;

/**
 * @author Artem Karnov @date 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface GenericService<E, K> {

    public void createEntity(E entity) throws DAOException;

    public E getEntityById(K id) throws DAOException;

    public void updateEntity(E entity) throws DAOException;

    public void deleteEntity(E entity) throws DAOException;

    public List<E> getAll() throws DAOException;


}