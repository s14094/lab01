package pl.pawellakomiec.repository;

import static org.junit.Assert.*;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.pawellakomiec.domain.Person;


@RunWith(JUnit4.class)
public class PersonDbunitTest extends DBTestCase {
    public static String url = "jdbc:hsqldb:hsql://localhost/workdb";

    PersonRepository personManager;

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        personManager = new PersonRepositoryImpl(DriverManager.getConnection(url));
    }

    @Ignore
    @Test
    public void doNothing() {
        assertEquals(4, personManager.getAllPersons().size());
    }

    @Test
    public void checkAdding() throws Exception {
        Person person = new Person();
        person.setName("Janek");
        person.setYob(1939);

        assertEquals(1, personManager.addPerson(person));

        // Data verification

        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("PERSON");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(actualTable, new String[] { "ID" });
        IDataSet expectedDataSet = getDataSet("ds-2.xml");
        ITable expectedTable = expectedDataSet.getTable("PERSON");
        Assertion.assertEquals(expectedTable, filteredTable);
        personManager.deletePerson(person); // wyczyszczenie
    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.INSERT;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return this.getDataSet("ds-1.xml");
    }

    protected IDataSet getDataSet(String datasetName) throws Exception {
        URL url = getClass().getClassLoader().getResource(datasetName);
        FlatXmlDataSet ret = new FlatXmlDataSetBuilder().build(url.openStream());
        return ret;
    }

}
