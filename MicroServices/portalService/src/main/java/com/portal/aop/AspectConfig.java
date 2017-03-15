package com.portal.aop;

/**
 * @author Artem Karnov @date 25.01.2017.
 * artem.karnov@t-systems.com
 **/

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.portal")
public class AspectConfig {
}
