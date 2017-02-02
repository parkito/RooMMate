package com.portal.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.portal.entities.User;

import java.util.List;

/**
 * @author Artem Karnov @date 30.01.17.
 *         artem.karnov@t-systems.com
 */
public class GroupDTO {
    private String title;
    private List<User> users;

    public String getTitle() {
        return title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
