package com.portal;

import com.portal.console.ConsoleUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.portal")
@EnableAutoConfiguration
public class SpringBootWebApplication extends SpringBootServletInitializer {
    ConsoleUI consoleUI = new ConsoleUI();

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
        SpringBootWebApplication app = new SpringBootWebApplication();
        app.consoleUI.firstScreen();
    }
}