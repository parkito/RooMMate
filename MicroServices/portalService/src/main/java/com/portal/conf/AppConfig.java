package com.portal.conf;

import com.portal.dao.implementation.UserDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Artem Karnov @date 24.01.17.
 *         artem.karnov@t-systems.com
 **/
@Configuration
@Import(JpaConfiguration.class)
@EnableWebMvc
@ComponentScan(basePackages = "com.portal")
public class AppConfig extends WebMvcConfigurerAdapter {
    private static Logger logger = LogManager.getLogger(AppConfig.class);

    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
        logger.info("Resolving paths for web-pages in com.portal.conf.AppConfig.class");
    }

    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        logger.info("Resolving resources for pages in com.portal.conf.AppConfig.class");
    }

    /**
     * Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.3.0.
     * This is a workaround for this issue.
     */

    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
        logger.info("Configuring path matches for pages in com.portal.conf.AppConfig.class");

    }
}
