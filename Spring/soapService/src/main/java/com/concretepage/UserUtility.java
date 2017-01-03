package com.concretepage;

import com.concretepage.entities.UserXML;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserXML s1;
    UserXML s2;

    public UserUtility() {
        s1 = new UserXML();
        s1.setIdUsers(1);
        s1.setName("Ram");
        s1.setEmail("a@b.ru");
        userMap.put(1, s1);
        s2 = new UserXML();
        s2.setIdUsers(2);
        s2.setName("Shyam");
        s2.setEmail("b@b.ru");
        userMap.put(2, s2);
    }

    public UserXML getUserXML(String email) {
        if (s1.getEmail().equals(email)) {
            return s1;
        } else {
            return s2;
        }

    }
}