package com.roommate.basecontrol.controllers;

import com.roommate.basecontrol.service.BaseControlServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Artem Karnov @date 07.04.17.
 *         artem.karnov@t-systems.com
 */
@Configuration
@ComponentScan(value = "com.roommate.basecontrol.controllers")
@Import(BaseControlServiceConfig.class)
@EnableWebMvc
public class BaseControlRestConfig {
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
