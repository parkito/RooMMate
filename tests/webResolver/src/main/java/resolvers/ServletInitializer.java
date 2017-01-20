package resolvers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Artem Karnov @date 08.01.17.
 *         artem.karnov@t-systems.com
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.portal, resolver"})
@EntityScan("com.portal")
@EnableJpaRepositories("com.portal")
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}

