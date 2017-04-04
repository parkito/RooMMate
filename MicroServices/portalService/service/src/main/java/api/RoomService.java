package api;

import com.portal.repository.entities.Room;
import com.portal.utils.exceptions.RoomNotFoundException;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/
public interface RoomService extends GenericService<Room, Integer> {
    public Room getRoomByTitle(String title) throws RoomNotFoundException;
}
