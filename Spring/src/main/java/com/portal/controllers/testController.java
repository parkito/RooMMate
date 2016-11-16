package com.portal.controllers;

import com.portal.entities.Group;
import com.portal.entities.User;
import com.portal.services.api.GroupService;
import com.portal.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//// TODO: 16.11.2016 логирование

/**
 * @author Artem Karnov @date 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Controller("TestController")
public class testController {
    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(@RequestParam(value = "name") String name,
                          @RequestParam(value = "secondName") String secondName,
                          @RequestParam(value = "eMail") String eMail,
                          @RequestParam(value = "password") String password) {
        //http://localhost:8099/addUser?name=name1&secondName=secondName2&eMail=eMail2&password=password3
        User user = new User(name, secondName, eMail, password);
        userService.createEntity(user);
        return "hello";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam(value = "eMail") String eMail) {
//        http://localhost:8099/deleteUser?email=email
        userService.deleteEntity(userService.getUserByEMAil(eMail));
        return "hello";
    }


    @RequestMapping(value = "/addGroupToUser", method = RequestMethod.GET)
    public String addGroupToUser(@RequestParam(value = "eMail") String eMail,
                                 @RequestParam(value = "groupId") int groupId) {
//        http://localhost:8099/deleteUser?email=email
        userService.deleteEntity(userService.getUserByEMAil(eMail));
        return "hello";
    }

    //// TODO: 16.11.2016 обработка эксепшенов 
    @RequestMapping(value = "/addGroup", method = RequestMethod.GET)
    public String addGroup(@RequestParam(value = "title") String title) {
//        http://localhost:8099/addGroup?title=title
        Group group = new Group(title);
        groupService.createEntity(group);
        return "hello";
    }

}
