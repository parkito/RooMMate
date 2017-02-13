package com.portal.controller;

import com.portal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Artem Karnov @date 03.02.2017.
 *         artem.karnov@t-systems.com
 */

@Controller
public class WelcomeController {
    private final static String REST_ADDRESS_OF_PI_SERVER = "http://localhost:8083/rest/";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    public User getUser(String eMail) {
        User user = restTemplate.getForObject(REST_ADDRESS_OF_PI_SERVER + "getUser?eMail="
                + eMail, User.class);
        return user;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUserRequest(HttpServletRequest req) {
        User user = getUser("email1");
        req.getSession().setAttribute("result", user);
        req.getSession().setAttribute("name", user.getName());
        req.getSession().setAttribute("secondName", user.getSecondName());
        req.getSession().setAttribute("groups", user.getGroups());
        return "welcome";
    }

    public String addUser(String name, String secondName, String eMail, String password) {
        User user = restTemplate.getForObject(REST_ADDRESS_OF_PI_SERVER + "addUser?name="
                + name + "&" + "secondName="
                + secondName + "&" + "eMail="
                + eMail + "&" + "password="
                + password, User.class);
        return "hello";
    }

}

