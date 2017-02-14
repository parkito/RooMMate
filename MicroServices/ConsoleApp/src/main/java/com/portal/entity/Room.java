package com.portal.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 01.02.2017.
 *         artem.karnov@t-systems.com
 */

public class Room implements Serializable {
//    @Id
//    @GeneratedValue
//    private Long id;
//    @Column
    private String title;
//    @Column
    private int maxMembers;
    // TODO: 01.02.2017 many to many
//    @Column
    private List<Group> groups = new ArrayList();

    public String getTitle() {
        return title;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
