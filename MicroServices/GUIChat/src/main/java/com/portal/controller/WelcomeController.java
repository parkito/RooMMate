package com.portal.controller;

import com.portal.exceptions.DAOException;
import com.portal.exceptions.ResponseEntityException;
import mainDomainModel.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Artem Karnov @date 03.02.2017.
 *         artem.karnov@t-systems.com
 */

@Controller
public class WelcomeController {
    private final static String REST_ADDRESS_OF_PI_SERVER = "http://localhost:8083/rest/";
    private final static String GET_USER = "getUser?";
    private final static String AND = "&";
    private final static String EMAIL_E = "eMail=";
    private final static String NAME_E = "name=";
    private final static String SECOND_NAME_E = "secondName=";
    private final static String PASSWORD_E = "password=";
    private final static String ADD_USER = "addUser?";

    //    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String welcome() {
        return "pages/welcomePage";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signInPage() {
        return "pages/sign-in";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUpPage() {
        return "pages/sign-up";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUserRequest(HttpServletRequest req) {
        User user = getUser("email1");
        req.getSession().setAttribute("result", user);
        req.getSession().setAttribute("name", user.getName());
        req.getSession().setAttribute("secondName", user.getSecondName());
        req.getSession().setAttribute("groups", user.getGroups());
        return "welcome";
    }

    public void addUser(String name, String secondName, String eMail, String password) {
        ResponseEntity response;
        try {
            response = restTemplate.getForObject(REST_ADDRESS_OF_PI_SERVER + ADD_USER +
                            NAME_E + name + AND +
                            SECOND_NAME_E + secondName + AND +
                            EMAIL_E + eMail + AND +
                            PASSWORD_E + password,
                    ResponseEntity.class);
        } catch (Exception ex) {
            throw new ResponseEntityException("Error in addUsers while adding " + eMail, ex);
        }

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new DAOException("User " + eMail + " wasn't added because " + response.getStatusCode());
        }
    }

    public User getUser(String eMail) {
        ResponseEntity<User> response = null;
        try {
            response = restTemplate.getForObject(
                    REST_ADDRESS_OF_PI_SERVER + GET_USER + EMAIL_E
                            + eMail, ResponseEntity.class);
        } catch (Exception ex) {
            throw new ResponseEntityException("Error in getUsers while getting " + eMail, ex);
        }

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new DAOException("User " + eMail + " wasn't gotten because " + response.getStatusCode());
        } else return response.getBody();
    }



    /*
    public List<RodsMalfunctionDataDiagnosticEvent> getEvents(Date from, Date to, String driverUuid) {
        log.debug("getMalfunctionAndDiagnosticEventsBetween(driverUuid={}, from={}, to={})" + driverUuid + from + to);
        String baseUri = Configuration.getString(PortalExtProperties.REST_RODS_SERVICE_ENDPOINT_URL);

        URI targetUrl = UriComponentsBuilder.fromUriString(baseUri).pathSegment("malfunction-data-diagnostic-event")
                .queryParam("rsqlQuery", rsqlQueryBuilder.findByEventTimestampBetween(driverUuid, from, to))
                .queryParam("sort", "eventTimestamp,ASC") //see spring data web support
                .queryParam("page", 0)
                .queryParam("size", Integer.MAX_VALUE).build().toUri();

        ResponseEntity<Page<RodsMalfunctionDataDiagnosticEvent>> responseEntity = restTemplate.exchange(
                targetUrl, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Page<RodsMalfunctionDataDiagnosticEvent>>() {
                });
        List<RodsMalfunctionDataDiagnosticEvent> result = responseEntity.getBody().getContent();
        log.debug("getMalfunctionAndDiagnosticEventsBetween: result = {}" + JsonPrinter.print(result));
        return result;
    }


@RequestMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody RodsData rodsData) {
        try {
            rodsService.save(rodsData);
        } catch (Exception e) {
            logger.error("Save error {}", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }





    */

}

