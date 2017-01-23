package resolvers.webPagesResolver.controllers;

import com.portal.entities.Grup;
import com.portal.entities.Room;
import com.portal.entities.User;
import com.portal.exceptions.DAOException;
import com.portal.services.api.GroupService;
import com.portal.services.api.RoomService;
import com.portal.services.api.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//// TODO: 16.11.2016 логирование
//// TODO: 25.11.2016 better exception handler 

/**
 * @author Artem Karnov @date 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Controller("WebController")
public class WebController {
    private static Logger logger = LogManager.getLogger(WebController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
        return "hello";
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String initialization(HttpServletRequest req) {
        try {
            //add users
            User user = new User("name1", "secondName1", "email1", "password1");
            User user1 = new User("name2", "secondName2", "email2", "password2");
            User user2 = new User("name3", "secondName3", "email3", "password3");
            User user3 = new User("name4", "secondName4", "email4", "password4");
            User user4 = new User("name5", "secondName5", "email5", "password5");
            User user5 = new User("name6", "secondName6", "email6", "password6");
            userService.createEntity(user);
            userService.createEntity(user1);
            userService.createEntity(user2);
            userService.createEntity(user3);
            userService.createEntity(user4);
            userService.createEntity(user5);

            //add grups
            Grup grup = new Grup("title");
            Grup grup1 = new Grup("title1");
            Grup grup2 = new Grup("title2");
            Grup grup3 = new Grup("title3");
            groupService.createEntity(grup);
            groupService.createEntity(grup1);
            groupService.createEntity(grup2);
            groupService.createEntity(grup3);

            //add rooms
            Room room = new Room("room1", 10);
            Room room1 = new Room("room2", 10);
            Room room2 = new Room("room3", 10);
            Room room3 = new Room("room4", 10);
            Room room4 = new Room("room5", 10);
            Room room5 = new Room("room6", 10);
            roomService.createEntity(room);
            roomService.createEntity(room1);
            roomService.createEntity(room2);
            roomService.createEntity(room3);
            roomService.createEntity(room4);
            roomService.createEntity(room5);

            //getting data from bd
            Room chRoom1 = roomService.getRoomByTitle(room.getTitle());
            Room chRoom2 = roomService.getRoomByTitle(room1.getTitle());
            Grup chGrup1 = groupService.getGroupByTitle(grup.getTitle());
            Grup chGrup2 = groupService.getGroupByTitle(grup2.getTitle());
            User chUser1 = userService.getUserByEMAil(user.getEmail());
            User chUser2 = userService.getUserByEMAil(user2.getEmail());

            //user to group
            chUser1.addGroup(chGrup2);
            chUser1.addGroup(chGrup1);
            chUser2.addGroup(chGrup1);
            userService.updateEntity(chUser1);
            userService.updateEntity(chUser2);

            //group to room
            chGrup1.addRoom(chRoom1);
            chGrup2.addRoom(chRoom2);
            groupService.updateEntity(chGrup1);
            groupService.updateEntity(chGrup2);


        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }

        return "hello";
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public String deleteAll(HttpServletRequest req) {
        try {
            List<User> users = userService.getAll();
            for (User usr : users) {
                userService.deleteEntity(usr);
            }
            List<Grup> grups = groupService.getAll();
            for (Grup grps : grups) {
                groupService.deleteEntity(grps);
            }

            List<Room> rooms = roomService.getAll();
            for (Room rms : rooms) {
                roomService.deleteEntity(rms);
            }
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }


        return "hello";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(HttpServletRequest req,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "secondName") String secondName,
                          @RequestParam(value = "eMail") String eMail,
                          @RequestParam(value = "password") String password) {
        //http://localhost:8099/addUser?name=name1&secondName=secondName2&eMail=eMail2&password=password3
        try {
            User user = new User(name, secondName, eMail, password);
            userService.createEntity(user);
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }

    @RequestMapping(value = "/addGroup", method = RequestMethod.GET)
    public String addGroup(HttpServletRequest req,
                           @RequestParam(value = "title") String title) {
//        http://localhost:8099/addGroup?title=title
        try {
            Grup grup = new Grup(title);
            groupService.createEntity(grup);
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.GET)
    public String addRoom(HttpServletRequest req,
                          @RequestParam(value = "title") String title,
                          @RequestParam(value = "maxMembers") int maxMembers) {
//        http://localhost:8099/addRoom?title=title&maxMembers=10
        try {
            Room room = new Room(title, maxMembers);
            roomService.createEntity(room);
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(HttpServletRequest req,
                          @RequestParam(value = "eMail") String eMail) {
//        http://localhost:8099/getUser?eMail=eMail22
        try {
            User user = userService.getUserByEMAil(eMail);
            System.out.println(user);
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }

        return "hello";
    }

    @RequestMapping(value = "/getGroup", method = RequestMethod.GET)
    public String getGroup(HttpServletRequest req,
                           @RequestParam(value = "title") String title) {
//        http://localhost:8099/getGroup?title=title
        try {
            Grup grup = groupService.getGroupByTitle(title);
            System.out.println(grup);
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }

    @RequestMapping(value = "/getRoom", method = RequestMethod.GET)
    public String getRoom(HttpServletRequest req,
                          @RequestParam(value = "title") String title) {
//        http://localhost:8099/getRoom?title=title
        try {
            Room room = roomService.getRoomByTitle(title);
            System.out.println(room);
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }

    @RequestMapping(value = "/addUserToGroup", method = RequestMethod.GET)
    public String addUserToGroup(HttpServletRequest req,
                                 @RequestParam(value = "eMail") String eMail,
                                 @RequestParam(value = "groupTitle") String groupTitle) {
//        http://localhost:8099/addUserToGroup?eMail=email&groupTitle=title
        try {
            User user = userService.getUserByEMAil(eMail);
            Grup grup = groupService.getGroupByTitle(groupTitle);
            user.addGroup(grup);
            userService.updateEntity(user);
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }

    @RequestMapping(value = "/addGroupToRoom", method = RequestMethod.GET)
    public String addGroupToRoom(HttpServletRequest req,
                                 @RequestParam(value = "roomTitle") String roomTitle,
                                 @RequestParam(value = "groupTitle") String groupTitle) {
//        http://localhost:8099/addGroupToRoom?roomTitle=room&groupTitle=title
        try {
            Room room = roomService.getRoomByTitle(roomTitle);
            Grup grup = groupService.getGroupByTitle(groupTitle);
            grup.addRoom(room);
            groupService.updateEntity(grup);
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest req,
                             @RequestParam(value = "eMail") String eMail) {
//        http://localhost:8099/deleteUser?eMail=email
        try {
            userService.deleteEntity(userService.getUserByEMAil(eMail));
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }

    @RequestMapping(value = "/deleteGroup", method = RequestMethod.GET)
    public String deleteGroup(HttpServletRequest req,
                              @RequestParam(value = "title") String title) {
//        http://localhost:8099/deleteGroup?title=title
        try {
            groupService.deleteEntity(groupService.getGroupByTitle(title));
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }

    @RequestMapping(value = "/deleteRoom", method = RequestMethod.GET)
    public String deleteRoom(HttpServletRequest req,
                             @RequestParam(value = "title") String title) {
//        http://localhost:8099/deleteRoom?title=title
        try {
            roomService.deleteEntity(roomService.getRoomByTitle(title));
        } catch (DAOException ex) {
            req.setAttribute("Message", ex.getStackTrace());
            req.setAttribute("Ex", ex);
            return "exception";
        }
        return "hello";
    }
}
