//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.02 at 11:26:45 AM IST 
//


package com.concretepage.soap;

import com.concretepage.entities.UserXML;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public GetUserRequest createGetUserRequest() {
        return new GetUserRequest();
    }

    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    public UserXML createUser() {
        return new UserXML();
    }
}
