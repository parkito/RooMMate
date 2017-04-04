package dao.api;


import com.portal.repository.entities.Room;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface RoomDAO extends GenericDAO<Room, Integer> {
    public Room getRoomByTitle(String title);
}