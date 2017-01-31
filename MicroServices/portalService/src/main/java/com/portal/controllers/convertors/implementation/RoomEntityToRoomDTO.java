package com.portal.controllers.convertors.implementation;

import com.portal.controllers.convertors.api.EntityToDTOConverter;
import com.portal.dto.RoomDTO;
import com.portal.dto.UserDTO;
import com.portal.entities.Room;
import com.portal.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 25.01.2017.
 *         artem.karnov@t-systems.com
 **/
public class RoomEntityToRoomDTO implements EntityToDTOConverter<Room, RoomDTO> {
    @Override
    public RoomDTO convert(Room entity) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setTitle(entity.getTitle());
        roomDTO.setMaxMembers(entity.getMaxMembers());
        roomDTO.setGroups(entity.getGroups());
        return roomDTO;
    }

    @Override
    public List<RoomDTO> convertList(List<Room> entitiesList) {
        List<RoomDTO> result = new ArrayList<>();
        for (Room roomEntity : entitiesList) {
            result.add(convert(roomEntity));
        }
        return result;
    }
}
