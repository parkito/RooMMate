package com.portal.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Entity
@Table(name = "Groups")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGroups")
    private int idGroups;

    @Basic
    @Column(name = "Title", nullable = false, length = 45)
    private String title;

    public Group() {
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Groups_has_Rooms",
            joinColumns = @JoinColumn(name = "GroupsIdGroups"),
            inverseJoinColumns = @JoinColumn(name = "RoomsIdRooms"))
    private List<Room> rooms = new ArrayList();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Users_has_Group",
            joinColumns = @JoinColumn(name = "GroupsIdGroups"),
            inverseJoinColumns = @JoinColumn(name = "UsersIdUsers"))
    private List<User> users = new ArrayList();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Group(String title) {
        this.title = title;
    }

    public int getIdGroups() {
        return idGroups;
    }

    public void setIdGroups(int idGroups) {
        this.idGroups = idGroups;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group groups = (Group) o;

        if (idGroups != groups.idGroups) return false;
        if (title != null ? !title.equals(groups.title) : groups.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGroups;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "idGroups=" + idGroups +
                ", title='" + title + '\'' +
                '}';
    }
}
