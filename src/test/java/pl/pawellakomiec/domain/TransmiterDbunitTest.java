package pl.pawellakomiec.domain;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.pawellakomiec.repository.TransmiterRepositoryDbunitTest;
import pl.pawellakomiec.repository.TransmiterRepositoryImpl;

import java.sql.DriverManager;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TransmiterRepositoryDbunitTest.class
})
public class TransmiterDbunitTest {
    @BeforeClass
    public static void before() throws Exception {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";

        new TransmiterRepositoryImpl(DriverManager.getConnection(url));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.hsqldb.jdbcDriver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:hsqldb:hsql://localhost/workdb");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");

        JdbcDatabaseTester databaseTester = new PropertiesBasedJdbcDatabaseTester();

        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(
                TransmiterDbunitTest.class.getClassLoader().
                        getResource("databaseDump.xml").openStream()
        );

        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @AfterClass
    public static void after() {
    }

}