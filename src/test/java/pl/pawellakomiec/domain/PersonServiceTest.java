package pl.pawellakomiec.domain;


import static junit.framework.Assert.assertEquals;

import java.util.List;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import pl.pawellakomiec.domain.Person;
import pl.pawellakomiec.service.PersonService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })


public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    @DatabaseSetup("sampleData.xml")
    public void testFind() throws Exception {
        List<Person> personList = personService.find("hil");
        assertEquals(1, personList.size());
        assertEquals("Phillip", personList.get(0).getFirstName());
    }
}
