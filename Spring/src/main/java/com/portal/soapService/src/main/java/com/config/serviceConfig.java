package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @author Artem Karnov @date 25.11.2016.
 *         artem.karnov@t-systems.com
 **/

@Configuration
@EnableWs
@ComponentScan("com.config")
public class serviceConfig extends WsConfigurerAdapter {

    @Bean(name = "users")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UsersPort");
        wsdl11Definition.setLocationUri("/soap");
        wsdl11Definition.setTargetNamespace("http://localhost:8080");
        wsdl11Definition.setSchema(studentsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema studentsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
    }
}
