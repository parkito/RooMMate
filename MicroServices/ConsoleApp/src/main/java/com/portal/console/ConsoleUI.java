package com.portal.console;

import org.springframework.stereotype.Component;

/**
 * @author Artem Karnov @date 14.02.2017.
 *         artem.karnov@t-systems.com
 */
@Component
public class ConsoleUI {
    private String eMail;
    private String password;

    public boolean checkCredentials(String eMail, String password){
        // TODO: 14.02.2017 implementation
        return true;
    }

    public void firstScreen(){}
}
