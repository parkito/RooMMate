package com.config;

import com.queries.GetUserRequest;
import com.queries.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Artem Karnov @date 29.11.2016.
 *         artem.karnov@t-systems.com
 **/

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080";
    @Autowired
    private UserUtility userUtility;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
    @ResponsePayload
    public GetUserResponse getCountry(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUserXML(userUtility.getUserXML(request.getUserId()));
        return response;
    }
}
