package com.roommate.basecontrol.service.conf;

import com.roommate.basecontrol.controllers.BaseControlRestConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Artem Karnov @date 24.01.17.
 *         artem.karnov@t-systems.com
 **/
@Configuration
@Import({JpaConfig.class,
        BaseControlRestConfig.class,
        AppInitializer.class})
@ComponentScan(basePackages = "com.roommate.basecontrol")
@EnableWebMvc
public class AppConfig  {


}
