package convertors.implementation;


import convertors.api.EntityToDTOConverter;
import dto.UserDTO;
import entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        userDTO.setGroups(entity.getGroups());
        return userDTO;
    }

    @Override
    public List<UserDTO> convertList(List<User> entitiesList) {
        List<UserDTO> result = new ArrayList<>();
        for (User userEntity : entitiesList) {
            result.add(convert(userEntity));
        }
        return result;
    }
}