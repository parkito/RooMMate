package com.roommate.basecontrol.controllers.restControllers;

import com.roommate.basecontrol.model.convertors.implementation.UserEntityToUserDTO;
import com.roommate.basecontrol.model.dto.UserDTO;
import com.roommate.basecontrol.repository.entities.User;
import com.roommate.basecontrol.service.api.UserService;
import com.roommate.basecontrol.utils.exceptions.UserNotFoundException;
import com.roommate.basecontrol.utils.security.PasswordChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Artem Karnov @date 07.04.17.
 *         artem.karnov@t-systems.com
 */
@Controller("UserController")
@RequestMapping(value = "/user")
public aspect UserController {
    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserEntityToUserDTO userConverter;

    @RequestMapping(value = "/getUserByCredentials", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserByCredentials(HttpServletRequest req,
                                                        @RequestParam(value = "email") String email,
                                                        @RequestParam(value = "password") String password) {
        User user;
        try {
            user = userService.getUserByEMAil(email);
        } catch (UserNotFoundException ex) {
            logger.warn("User" + email + " required by " + req.getHeader("service") + " wasn't found.");
            return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
        }

        if (PasswordChecker.check(user.getPassword(), password)) {
            UserDTO result = userConverter.convert(user);
            return new ResponseEntity<UserDTO>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserDTO>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<List<UserDTO>> getUserList(List<String> email) {
        return null;
    }

    public UserDTO getUserByEmail(String email) {
        return null;
    }

    public ResponseEntity persisUser(UserDTO user) {
        new ResponseEntity(HttpStatus.CONFLICT);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity persistUsers(List<UserDTO> users) {
        new ResponseEntity(HttpStatus.CONFLICT);
        return new ResponseEntity(HttpStatus.OK);
    }


}
