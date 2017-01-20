package resolvers.soapResolver.controllers;

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

    @RequestMapping(value = "/soap/*", method = RequestMethod.GET)
    public String soapService(HttpServletRequest req) {
        System.out.println("here");
        return "hello";
    }
}
