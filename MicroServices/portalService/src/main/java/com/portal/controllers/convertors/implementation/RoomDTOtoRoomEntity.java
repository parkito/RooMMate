package com.portal.controllers.convertors.implementation;

import com.portal.controllers.convertors.api.DTOtoEntityConverter;
import com.portal.dto.RoomDTO;
import com.portal.dto.UserDTO;
import com.portal.entities.Room;
import com.portal.entities.User;
import com.portal.exceptions.EntityToDTOConvertException;
import com.portal.exceptions.RoomNotFoundException;
import com.portal.services.api.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 25.01.2017.
 *         artem.karnov@t-systems.com
 **/
@Component
public class RoomDTOtoRoomEntity implements DTOtoEntityConverter<RoomDTO, Room> {
    @Autowired
    RoomService roomService;

    @Override
    public Room convert(RoomDTO dto) {
        Room room = null;
        try {
            room = roomService.getRoomByTitle(dto.getTitle());
        } catch (RoomNotFoundException ex) {
            throw new EntityToDTOConvertException("Room " + dto.getTitle() + " wasn't found", ex);
        }
        return room;
    }

    @Override
    public List<Room> convertList(List<RoomDTO> dtoList) {
        List<Room> result = new ArrayList<>();
        for (RoomDTO roomDTO : dtoList) {
            result.add(convert(roomDTO));
        }
        return result;
    }
}
