package com.portal.controllers.convertors.implementation;

import com.portal.controllers.convertors.api.EntityToDTOConverter;
import com.portal.dto.RoomDTO;
import com.portal.entities.Room;

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
        roomDTO.setGroups(entity.getGrups());
        return roomDTO;
    }
}
