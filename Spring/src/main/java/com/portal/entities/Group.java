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
@Table(name = "Group")
@NamedQuery(name = "Group.getAll", query = "SELECT g FROM Group g")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGroups")
    private int idGroups;

    @Basic
    @Column(name = "Title", length = 45)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "User_has_Group", joinColumns = {
            @JoinColumn(name = "idGroups")},
            inverseJoinColumns = {@JoinColumn(name = "User_idUsers")})
    private List<User> users = new ArrayList();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Group_has_Room", joinColumns = {
            @JoinColumn(name = "idRooms")},
            inverseJoinColumns = {@JoinColumn(name = "Room_idRooms")})
    private List<Room> rooms = new ArrayList<>();

    public Group() {
    }

    public Group(String title) {
        this.title = title;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public int getIdGroups() {
        return idGroups;
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
