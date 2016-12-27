package com.concretepage.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Artem Karnov @date 25.11.2016.
 *         artem.karnov@t-systems.com
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "idUsers"
})
@XmlRootElement(name = "getUserRequest")
public class GetUserRequest {
    protected int idUsers;


    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public int getIdUsers() {

        return idUsers;
    }

}
