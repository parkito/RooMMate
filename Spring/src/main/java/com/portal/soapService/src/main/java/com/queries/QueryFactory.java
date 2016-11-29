package com.queries;

import com.entities.UserXML;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * @author Artem Karnov @date 25.11.2016.
 *         artem.karnov@t-systems.com
 **/

@XmlRegistry
public class QueryFactory {

    public QueryFactory() {
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
