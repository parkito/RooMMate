package com.portal.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
@Entity
@Table(name = "Groups_has_Rooms", schema = "mydb", catalog = "")
public class GroupsHasRooms implements Serializable {
    private int groupsIdGroups;
    private int roomsIdRooms;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Groups_idGroups", nullable = false)
    public int getGroupsIdGroups() {
        return groupsIdGroups;
    }

    public void setGroupsIdGroups(int groupsIdGroups) {
        this.groupsIdGroups = groupsIdGroups;
    }

    @Id
    @Column(name = "Rooms_idRooms", nullable = false)
    public int getRoomsIdRooms() {
        return roomsIdRooms;
    }

    public void setRoomsIdRooms(int roomsIdRooms) {
        this.roomsIdRooms = roomsIdRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupsHasRooms that = (GroupsHasRooms) o;

        if (groupsIdGroups != that.groupsIdGroups) return false;
        if (roomsIdRooms != that.roomsIdRooms) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupsIdGroups;
        result = 31 * result + roomsIdRooms;
        return result;
    }
}
