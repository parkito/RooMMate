package soapResolver.controllers;

import com.concretepage.AppConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Artem Karnov @date 06.01.17.
 *         artem.karnov@t-systems.com
 **/
@Controller("SoapController")
public class SoapController {

    @RequestMapping(value = "/soapws", method = RequestMethod.GET)
    public String soapService(HttpServletRequest req) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        return "hello";
    }
}
