package com.portal.config;

import com.portal.entities.UserXML;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Karnov @date 29.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Component
public class UserUtility {
    private Map<Integer, UserXML> userMap = new HashMap<Integer, UserXML>();

    public UserUtility() {
        UserXML s1 = new UserXML();
        s1.setIdUsers(1);
        s1.setName("Ram");
        userMap.put(1, s1);
        UserXML s2 = new UserXML();
        s2.setIdUsers(2);
        s2.setName("Shyam");
        userMap.put(2, s2);
    }

    public UserXML getUserXML(int userId) {
        return userMap.get(userId);
    }
}