package com.portal.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Entity
@Table(name = "Grup")
@NamedQuery(name = "Grup.getAll", query = "SELECT g FROM Grup g")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGroups")
    private int idGroups;

    @Basic
    @Column(name = "title", length = 45)
    private String title;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "User_has_Grup", joinColumns = {
            @JoinColumn(name = "Grup_idGroups")},
            inverseJoinColumns = {@JoinColumn(name = "User_idUsers")})
    private List<User> users;

    public Group() {
    }

    public Group(String title) {
        this.title = title;
    }

//    public void addUser(User user) {
//        if (!users.contains(user)) {
//            users.add(user);
//        } else throw new DAOException(user.getEmail() + " already in " + title);
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }

//    public List<Room> getRooms() {
//        return rooms;
//    }

//    public void addRoom(Room room) {
//        rooms.add(room);
//    }

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
