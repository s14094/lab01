package transmiterTests.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.pawellakomiecrest.domain.Transmiter;
import pl.pawellakomiecrest.service.TransmiterRepository;
import pl.pawellakomiecrest.service.TransmiterRepositoryImpl;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TransmiterRepoTest {
    TransmiterRepository transmiterRepository;

    @Before
    public void setup() throws SQLException {
        transmiterRepository = new TransmiterRepositoryImpl();
    }

    @After
    public void cleanup() throws SQLException {
    //transmiterRepository.dropDatatable();
    }

    @Test
    public void checkConnection() {
        assertNotNull(transmiterRepository.getConnection());
    }


    /*
    @Test
    public void checkAdding() throws SQLException{
        Transmiter undead = new Transmiter();
        Transmiter.setId(1);
        Transmiter.setName("xaomi");
        assertEquals(1, transmiterRepository.addTransmiter(Transmiter));
    }
    */

}
