package com.concretepage;

import com.concretepage.entities.UserXML;
import com.portal.entities.User;
import com.portal.exceptions.UserNotFoundException;
import com.portal.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Artem Karnov @date 29.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Component
public class UserUtility {
    @Autowired
    private UserService userService;

    public UserUtility() {

    }

    public UserXML getUserXML(String email) {
        UserXML userXML = new UserXML();
        User user = null;
        try {
            user = userService.getUserByEMAil(email);
        } catch (UserNotFoundException ex) {
            ex.printStackTrace();
        }

        userXML.setIdUsers(user.getIdUsers());
        userXML.setName(user.getName());
        userXML.setSecondName(user.getSecondName());
        userXML.setEmail(user.getEmail());
        userXML.setPassword(user.getPassword());

        return userXML;
    }
}