package com.concretepage.soap;

import com.concretepage.entities.UserXML;

import javax.xml.bind.annotation.*;

/**
 * @author Artem Karnov @date 25.11.2016.
 *         artem.karnov@t-systems.com
 **/

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "user"
})
@XmlRootElement(name = "getUserResponse")
public class GetUserResponse {

    @XmlElement(required = true)
    protected UserXML user;

    /**
     * Gets the value of the user property.
     *
     * @return possible object is
     * {@link UserXML }
     */
    public UserXML getUserXML() {
        return user;
    }


    public void setUserXML(UserXML value) {
        this.user = value;
    }


}