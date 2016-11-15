package com.portal.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Entity
@Table(name = "Users_has_Groups", schema = "mydb", catalog = "")
public class UsersHasGroups implements Serializable {
    private int usersIdUsers;
    private int groupsIdGroups;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Users_idUsers", nullable = false)
    public int getUsersIdUsers() {
        return usersIdUsers;
    }

    public void setUsersIdUsers(int usersIdUsers) {
        this.usersIdUsers = usersIdUsers;
    }

    @Id
    @Column(name = "Groups_idGroups", nullable = false)
    public int getGroupsIdGroups() {
        return groupsIdGroups;
    }

    public void setGroupsIdGroups(int groupsIdGroups) {
        this.groupsIdGroups = groupsIdGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersHasGroups that = (UsersHasGroups) o;

        if (usersIdUsers != that.usersIdUsers) return false;
        if (groupsIdGroups != that.groupsIdGroups) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usersIdUsers;
        result = 31 * result + groupsIdGroups;
        return result;
    }
}
