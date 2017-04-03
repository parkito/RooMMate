package com.portal.console;

import com.portal.controller.LoggingInterceptor;
import com.portal.controller.TransactionInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Artem Karnov @date 16.03.17.
 *         artem.karnov@t-systems.com
 */

@Configuration
@ComponentScan("com.portal")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
//    @Autowired
//    private InterceptDelegator interceptDelegator

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor());
        registry.addInterceptor(new TransactionInterceptor()).addPathPatterns("/person/save/*");
    }
}