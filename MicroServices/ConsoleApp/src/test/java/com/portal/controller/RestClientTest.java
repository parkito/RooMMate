package com.portal.controller;

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
@SpringBootTest(classes = {RestClient.class,RestTemplate.class})
public class RestClientTest {

    @Autowired
    RestClient restClient;

    @Test
    public void firstTest() {
        restClient.getUser("email1", "password1");
    }

}