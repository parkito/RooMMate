package com.portal.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Entity
public class Room implements Serializable {
    private int idRooms;
    private String title;
    private Integer maxMembers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRooms", nullable = false)
    public int getIdRooms() {
        return idRooms;
    }

    public void setIdRooms(int idRooms) {
        this.idRooms = idRooms;
    }

    @Basic
    @Column(name = "Title", nullable = true, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "MaxMembers", nullable = true)
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
