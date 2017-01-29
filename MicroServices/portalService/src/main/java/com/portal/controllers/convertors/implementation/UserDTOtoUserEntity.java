package com.portal.controllers.convertors.implementation;


import com.portal.controllers.convertors.api.DTOtoEntityConverter;
import com.portal.dto.UserDTO;
import com.portal.entities.User;
import com.portal.exceptions.EntityToDTOConvertException;
import com.portal.exceptions.UserNotFoundException;
import com.portal.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Artem Karnov @date 25.01.2017.
 *         artem.karnov@t-systems.com
 **/

public class UserDTOtoUserEntity {
public class UserDTOtoUserEntity implements DTOtoEntityConverter<UserDTO, User> {
    @Autowired
    UserService userService;

    @Override
    public User convert(UserDTO dto) {
        User user = null;
        try {
            user = userService.getUserByEMAil(dto.getEmail());
        } catch (UserNotFoundException ex) {
            throw new EntityToDTOConvertException("User " + dto.getEmail() + " wasn't found", ex);
        }
        return user;
    }

}
