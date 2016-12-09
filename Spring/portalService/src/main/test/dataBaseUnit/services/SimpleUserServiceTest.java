package dataBaseUnit.services;

import com.portal.entities.User;
import com.portal.services.api.UserService;
import dataBaseUnit.services.contexsts.TestDataBaseConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Artem Karnov @date 09.12.2016.
 *         artem.karnov@t-systems.com
 **/
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class SimpleUserServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveBank() throws Exception {
        User user = new User("NameUnic", "SecondName", "EmailUnic", "Password");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        userService.createEntity(user);
        System.out.println(userService.getUserByEMAil(user.getEmail()));
        Assert.assertNotEquals(userService.getUserByEMAil(user.getEmail()), null);
    }
}