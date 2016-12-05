package com.portal.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 25.11.2016.
 *         artem.karnov@t-systems.com
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
        "idUsers",
        "name",
        "secondName",
        "email",
        "password"
})
public class UserXML {

    protected int idUsers;
    @XmlElement(name = "name")
    protected String name;
    @XmlElement(name = "secondName")
    protected String secondName;
    @XmlElement(name = "email", required = true)
    protected String email;
    @XmlElement(name = "password")
    protected String password;
    @XmlElement(name = "groups")
    protected List<GroupXML> groups = new ArrayList();


    public void addGroup(GroupXML grup) {
        groups.add(grup);
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public List<GroupXML> getGroups() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}