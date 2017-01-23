package com.portal.services.api;

import com.portal.entities.Room;
import com.portal.exceptions.RoomNotFoundException;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface RoomService extends GenericService<Room, Integer> {
    public Room getRoomByTitle(String title) throws RoomNotFoundException;
}
