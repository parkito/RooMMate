package mainDomainModel.entities;


import mainDomainModel.exceptions.DAOException;

import java.io.Serializable;
import java.util.List;

/**
 * @author Artem Karnov 16.03.2017.
 *         artem.karnov@t-systems.com
 **/
public class User implements Serializable {
    private int idUsers;
    private String name;
    private String secondName;
    private String email;
    private List<Group> groups;

    public User() {
    }

    public User(String name, String secondName, String email) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
    }

    public void addGroup(Group grup) {
        if (!groups.contains(grup))
            groups.add(grup);
        else
            throw new DAOException(grup.getTitle() + " already in " + email);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUsers != user.idUsers) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (secondName != null ? !secondName.equals(user.secondName) : user.secondName != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsers;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUsers=" + idUsers +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                groups +
                '}';
    }
}
