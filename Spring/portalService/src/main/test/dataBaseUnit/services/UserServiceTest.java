package dataBaseUnit.services;


import com.portal.entities.User;
import com.portal.services.api.UserService;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dataBaseUnit.config.DBUnitConfig;
import dataBaseUnit.services.contexsts.UserServiceTestContext;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserServiceTestContext.class})
//@DatabaseSetup(type = DatabaseOperation.REFRESH, value = {"User.xml"})
public class UserServiceTest extends DBUnitConfig {


    @Autowired
    private UserService userService;

    public UserServiceTest() {
        
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("DB/User.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }


    @Test
    public void testGetAll() throws Exception {
        List<User> persons = userService.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("DB/User.xml"));
        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("User").getRowCount(), persons.size());
    }

//    @Test
//    public void testSave() throws Exception {
//        Person person = new Person();
//        person.setName("Lilia");
//        person.setSurname("Vernugora");
//
//        service.save(person);
//
//        IDataSet expectedData = new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/devcolibri/entity/person/person-data-save.xml"));
//        IDataSet actualData = tester.getConnection().createDataSet();
//
//        DatabaseOperation.CLEAN_INSERT.execute(getConnection(), expectedData);
//
//        String[] ignore = {"id"};
//        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "person", ignore);
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        Person person = new Person();
//        person.setName("Alexander");
//        person.setSurname("Kril");
//
//        person = em.merge(person);
//
//        int id = person.getId();
//
//        service.delete(person);
//        Person personFromDb = em.find(Person.class, id);
//
//        Assert.assertNull(personFromDb);
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        Person person = em.find(Person.class, 1);
//        person.setName("Alex");
//        service.update(person);
//        Person personFromDb = em.find(Person.class, 1);
//
//        Assert.assertEquals(person.getName(), personFromDb.getName());
//    }
//
//    @Test
//    public void testGetById() throws Exception {
//        Person person = service.get(1);
//        Person person1 = em.find(Person.class, 1);
//
//        Assert.assertEquals(person.getId(), person1.getId());
//        Assert.assertEquals(person.getName(), person1.getName());
//        Assert.assertEquals(person.getSurname(), person1.getSurname());
//    }
}
