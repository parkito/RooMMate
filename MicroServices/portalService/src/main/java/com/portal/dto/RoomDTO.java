package com.portal.dto;

import com.portal.entities.Group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 30.01.17.
 *         artem.karnov@t-systems.com
 */

public class RoomDTO implements Serializable {

    private String title;
    private int maxMembers;
    private List<Group> groups = new ArrayList<>();

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
