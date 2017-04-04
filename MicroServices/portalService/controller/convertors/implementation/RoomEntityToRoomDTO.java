package com.portal.controller.convertors.implementation;

import com.portal.controller.convertors.api.EntityToDTOConverter;
import com.portal.model.RoomDTO;
import com.portal.repository.entities.Room;

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
