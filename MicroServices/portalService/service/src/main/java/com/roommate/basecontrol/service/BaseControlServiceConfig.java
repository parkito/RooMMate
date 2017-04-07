package com.roommate.basecontrol.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Artem Karnov @date 07.04.17.
 *         artem.karnov@t-systems.com
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.roommate.basecontrol")
public class BaseControlServiceConfig {
}
