package api;


import entities.Room;
import exceptions.RoomNotFoundException;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface RoomService extends GenericService<Room, Integer> {
    public entities.Room getRoomByTitle(String title) throws RoomNotFoundException;
}
