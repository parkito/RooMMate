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
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRooms")
    private int idRooms;
    @Basic
    @Column(name = "Title", length = 45)
    private String title;
    @Basic
    @Column(name = "MaxMembers")
    private Integer maxMembers;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "Groups_has_Rooms",
//            joinColumns = @JoinColumn(name = "RoomsIdRooms"),
//            inverseJoinColumns = @JoinColumn(name = "GroupsIdGroups"))
//    private Group group;

    public Room() {
    }

    public Room(String title,int maxMembers) {
        this.title = title;
        this.maxMembers=maxMembers;
    }

    public int getIdRooms() {
        return idRooms;
    }

    public void setIdRooms(int idRooms) {
        this.idRooms = idRooms;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(Integer maxMembers) {
        this.maxMembers = maxMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room rooms = (Room) o;

        if (idRooms != rooms.idRooms) return false;
        if (title != null ? !title.equals(rooms.title) : rooms.title != null) return false;
        if (maxMembers != null ? !maxMembers.equals(rooms.maxMembers) : rooms.maxMembers != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRooms;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (maxMembers != null ? maxMembers.hashCode() : 0);
        return result;
    }
}
