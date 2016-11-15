package com.portal.services.api;

import com.portal.exceptions.CustomDAOException;

import java.util.List;

/**
 * @author Artem Karnov @date 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface GenericService<E, K> {

    public void createEntity(E entity) throws CustomDAOException;

    public E getEntityById(K id) throws CustomDAOException;

    public void updateEntity(E entity) throws CustomDAOException;

    public void deleteEntity(E entity) throws CustomDAOException;

    public List<E> getAll() throws CustomDAOException;


}