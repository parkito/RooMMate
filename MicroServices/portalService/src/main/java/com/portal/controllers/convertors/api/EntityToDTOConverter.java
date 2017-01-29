package com.portal.controllers.convertors.api;

/**
 * @author Artem Karnov @date 25.01.2017.
 *         artem.karnov@t-systems.com
 **/
public interface EntityToDTOConverter<E, D> {
    D convert(E entity);
}
