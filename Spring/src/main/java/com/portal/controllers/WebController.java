package com.portal.controllers;

import com.portal.entities.Grup;
import com.portal.entities.Room;
import com.portal.entities.User;
import com.portal.services.api.GroupService;
import com.portal.services.api.RoomService;
import com.portal.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//// TODO: 16.11.2016 логирование
//// TODO: 17.11.2016 To solve dependisies betwean entities 

/**
 * @author Artem Karnov @date 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Controller("WebController")
public class WebController {
    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private RoomService roomService;

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
//        http://localhost:8099/deleteUser?eMail=email
        userService.deleteEntity(userService.getUserByEMAil(eMail));
        return "hello";
    }


    @RequestMapping(value = "/addGroupToUser", method = RequestMethod.GET)
    public String addGroupToUser(@RequestParam(value = "eMail") String eMail,
                                 @RequestParam(value = "groupTitle") String groupTitle) {
//        http://localhost:8099/addGroupToUser?eMail=email&groupTitle=title
        User user = userService.getUserByEMAil(eMail);
        Grup grup = groupService.getGroupByTitle(groupTitle);
//        user.addGroup(grup);
        userService.updateEntity(user);
        return "hello";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(@RequestParam(value = "eMail") String eMail) {
//        http://localhost:8099/getUser?eMail=eMail22
        User user = userService.getUserByEMAil(eMail);
        System.out.println(user);
        return "hello";
    }

    //// TODO: 16.11.2016 обработка эксепшенов 
    @RequestMapping(value = "/addGroup", method = RequestMethod.GET)
    public String addGroup(@RequestParam(value = "title") String title) {
//        http://localhost:8099/addGroup?title=title
        Grup grup = new Grup(title);
        groupService.createEntity(grup);
        return "hello";
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.GET)
    public String addRoom(@RequestParam(value = "title") String title,
                          @RequestParam(value = "maxMembers") int maxMembers) {
//        http://localhost:8099/addRoom?title=title&maxMembers=10
        Room room = new Room(title, maxMembers);
        roomService.createEntity(room);
        return "hello";
    }

    @RequestMapping(value = "/getGroup", method = RequestMethod.GET)
    public String getGroup(@RequestParam(value = "title") String title) {
//        http://localhost:8099/getGroup?title=title
        Grup grup = groupService.getGroupByTitle(title);
        System.out.println(grup);
        return "hello";
    }

    @RequestMapping(value = "/getRoom", method = RequestMethod.GET)
    public String getRoom(@RequestParam(value = "title") String title) {
//        http://localhost:8099/getRoom?title=title
        Room room = roomService.getRoomByTitle(title);
        System.out.println(room);
        return "hello";
    }

}
