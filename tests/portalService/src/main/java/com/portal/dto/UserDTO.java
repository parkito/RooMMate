package com.portal.dto;

import java.io.Serializable;

/**
 * @author Artem Karnov @date 07.01.17.
 *         artem.karnov@t-systems.com
 **/
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L;

    private String name;
    private String secondName;
    private String email;

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
