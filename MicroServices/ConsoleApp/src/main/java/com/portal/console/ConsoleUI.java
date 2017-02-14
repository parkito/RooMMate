package com.portal.console;

import com.portal.controller.RestClient;
import com.portal.exceptions.ResponseEntityException;
import mainDomainModel.User;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author Artem Karnov @date 14.02.2017.
 *         artem.karnov@t-systems.com
 */
@Component
public class ConsoleUI {
    private String eMail;
    private String password;
    private RestClient restClient = new RestClient();

    public boolean checkCredentials(String eMail, String password) {
        User user;
        try {
            user = restClient.getUser(eMail, password);
        } catch (ResponseEntityException ex) {
            return false;
        }
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    public void firstScreen() {
        // TODO: 14.02.2017 clear console and welcoming
        System.out.println("Enter your email --> ");
        Scanner in = new Scanner(System.in);
        eMail = in.nextLine();
        System.out.println("Enter your password --> ");
        password = in.nextLine();
        System.out.println(eMail + " " + password);
        signInScreen();
    }

    public void signInScreen() {
        if (checkCredentials(eMail, password)) {
            System.out.println("You are welcome!");
            successLogin();
        } else {
            System.out.println("Your credentials are not correct. Try again! ");
            firstScreen();
        }
    }

    public void successLogin() {
        System.out.println("YES");
    }
}
