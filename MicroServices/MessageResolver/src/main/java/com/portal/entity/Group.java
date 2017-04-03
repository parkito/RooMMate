package com.portal.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Artem Karnov @date 01.02.2017.
 *         artem.karnov@t-systems.com
 */

public class Group implements Serializable {
    //    @Id
//    @GeneratedValue
    private Long id;
    //    @Column
    private String title;
    // TODO: 01.02.2017 Many to many
//    @Column
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
