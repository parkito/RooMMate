package com.portal.controller;

import mainDomainModel.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author Artem Karnov @date 16.03.17.
 *         artem.karnov@t-systems.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RestClient.class, RestTemplate.class})
public class RestClientTest {

    @Autowired
    RestClient restClient;

    private User user;

    @Before
    public void setUp() {
    }

    @Test
    public void firstTest() {
        user = restClient.getUser("email1", "password1");

    }

    @Test
    public void secondTest() {
        user = restClient.getUser("email11", "password1");
    }

}