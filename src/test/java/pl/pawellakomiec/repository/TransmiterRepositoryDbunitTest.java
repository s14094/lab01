package pl.pawellakomiec.repository;


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
import pl.pawellakomiec.domain.Transmiter;

import java.net.URL;
import java.sql.SQLException;


@Ignore
@RunWith(JUnit4.class)
public class TransmiterRepositoryDbunitTest extends DBTestCase {
    public static String url = "jdbc:hsqldb:hsql://localhost/workdb";


    TransmiterRepository transmiterRepository;

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Before
    public void setUp() throws Exception {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        super.setUp();
        transmiterRepository = TransmiterRepositoryFactory.getInstance();
    }

    @Test
    public void doNothing() throws SQLException {
        assertNotNull(transmiterRepository.getAll());
    }


    public void checkAdding() throws Exception {

        Transmiter transmiter = new Transmiter();
        transmiter.setName("addtestTransdbunit");
        transmiter.setPrice(32);
        transmiter.setPower(33);

        assertEquals(1, transmiterRepository.addTransmiter(transmiter));


        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("TRANSMITER");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(actualTable, new String[]{"ID"});
        IDataSet expectedDataSet = getDataSet("ds-2.xml");
        ITable expectedTable = expectedDataSet.getTable("TRANSMITER");
        Assertion.assertEquals(expectedTable, filteredTable);
        transmiterRepository.deleteTransmiter(transmiter);
    }

    @Test
    public void checkSelect() throws Exception {
        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("TRANSMITER");
//        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(actualTable, new String[]{"ID"});
        IDataSet expectedDataSet = getDataSet("ds-1.xml");
        ITable expectedTable = expectedDataSet.getTable("TRANSMITER");
        Assertion.assertEquals(expectedTable, actualTable);
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