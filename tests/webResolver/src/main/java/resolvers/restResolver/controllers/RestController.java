package resolvers.restResolver.controllers;

import com.portal.dto.UserDTO;
import com.portal.entities.User;
import com.portal.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Artem Karnov @date 07.01.17.
 *         artem.karnov@t-systems.com
 **/
@Controller("RestController")
public class RestController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/rest/getUser", method = RequestMethod.GET)
    public
    @ResponseBody
    UserDTO getUser(@RequestParam(value = "email") String email) {
        UserDTO userDTO = new UserDTO();
        User user = userService.getUserByEMAil(email);
        userDTO.setName(user.getName());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
