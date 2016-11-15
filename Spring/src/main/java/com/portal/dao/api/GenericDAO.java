package com.portal.dao.api;

import com.portal.exceptions.CustomDAOException;

import java.util.List;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface GenericDAO<E, K> {


    public void create(E entity) throws CustomDAOException;

    public E read(K id) throws CustomDAOException;

    public void update(E entity) throws CustomDAOException;

    public void delete(E entity) throws CustomDAOException;

    public List<E> getAll() throws CustomDAOException;

}
