package com.portal.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author Artem Karnov @date 16.03.17.
 *         artem.karnov@t-systems.com
 */

public class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution ) throws IOException {

        System.out.println("--------------------------------------------------------------");
        return execution.execute(request, body);
    }
}
