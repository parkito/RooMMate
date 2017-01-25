package com.portal.controllers.convertors.implementation;

import com.portal.controllers.convertors.api.EntityToDTOConverter;
import com.portal.dto.UserDTO;
import com.portal.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author Artem Karnov @date 25.01.2017.
 *         artem.karnov@t-systems.com
 **/
@Component
public class UserEntityToUserDTO implements EntityToDTOConverter<User, UserDTO> {
    @Override
    public UserDTO convert(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(entity.getEmail());
        userDTO.setName(entity.getName());
        userDTO.setSecondName(entity.getSecondName());
        return userDTO;
    }
}
