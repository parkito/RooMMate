package mainDomainModel.entities;


import mainDomainModel.exceptions.DAOException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov 16.03.2017.
 *         artem.karnov@t-systems.com
 **/
public class Room implements Serializable {
    private int idRooms;
    private String title;
    private int maxMembers;
    private List<Group> groups = new ArrayList<>();

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Room() {
    }

    public Room(String title, int maxMembers) {
        this.title = title;
        this.maxMembers = maxMembers;
    }


    public void addGroup(Group group) {
        if (!groups.contains(group)) {
            groups.add(group);
        } else throw new DAOException(group.getTitle() + " already in " + title);
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

        Room room = (Room) o;

        if (idRooms != room.idRooms) return false;
        if (maxMembers != room.maxMembers) return false;
        if (title != null ? !title.equals(room.title) : room.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRooms;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + maxMembers;
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRooms=" + idRooms +
                ", title='" + title + '\'' +
                ", maxMembers=" + maxMembers +
                '}';
    }
}
