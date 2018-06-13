package pl.pawellakomiec.repository;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.pawellakomiec.domain.Transmiter;

import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class TransmiterRepositoryTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    TransmiterRepository transmiterRepository;

    @Before
    public void initRepository() {

        transmiterRepository = TransmiterRepositoryFactory.getInstance();
        Transmiter transmiter1 = new Transmiter();
        Transmiter transmiter2 = new Transmiter();
        Transmiter transmiter3 = new Transmiter();
        Transmiter transmiter4 = new Transmiter();

        transmiter1.setId(1);
        transmiter1.setName("transmiter1");
        transmiter1.setPrice(100);
        transmiter1.setPower(40);

        transmiter2.setId(2);
        transmiter2.setName("transmiter2");
        transmiter2.setPrice(200);
        transmiter2.setPower(40);

        transmiter3.setId(3);
        transmiter3.setName("transmiter3");
        transmiter3.setPrice(300);
        transmiter3.setPower(40);

        transmiter4.setId(4);
        transmiter4.setName("transmiter4");
        transmiter4.setPrice(400);
        transmiter4.setPower(40);

        transmiterRepository.addTransmiter(transmiter1);
        transmiterRepository.addTransmiter(transmiter2);
        transmiterRepository.addTransmiter(transmiter3);
        transmiterRepository.addTransmiter(transmiter4);
    }

    @Test
    public void get_all() throws SQLException {
        assertNotNull(transmiterRepository.getAll());
    }

    @Test
    public void create_transmiter() throws SQLException {
        Transmiter transmiter5 = new Transmiter();
        transmiter5.setName("createtransmiter5");
        transmiter5.setPrice(50);
        transmiter5.setPower(30);
        transmiterRepository.addTransmiter(transmiter5);
        assertNotNull(transmiterRepository.getById(transmiter5.getId()));
    }

    @Test
    public void delete_transmiter() throws SQLException {
        Transmiter transmiterNew = new Transmiter();
        transmiterNew.setName("deletetransmiter33");
        transmiterNew.setId(33);
        transmiterNew.setPrice(50);
        transmiterNew.setPower(30);
        transmiterRepository.deleteTransmiter(transmiterNew);
        if (transmiterRepository.getAll().isEmpty()) {
            assertTrue(false);
        }
    }

    @Test
    public void search_transmiter() throws SQLException {
        int idToFind = 1;
        assertNotNull(transmiterRepository.getById(idToFind));
    }

    @Test
    public void update_transmiter() throws SQLException {

        Transmiter transmiter2 = transmiterRepository.getById(2);

        int updateId = 1;
        transmiter2.setName("transmiter222");

        transmiterRepository.updateTransmiter(updateId, transmiter2);
        assertEquals(transmiterRepository.getById(updateId).getName(), transmiter2.getName());

        transmiterRepository.getAll().forEach(x -> {
            int updateNumber = 0;
            if (x.getName().equals(transmiter2.getName())) {
                updateNumber++;
                if (updateNumber > 1) {
                    assertTrue(false);
                }
            }
        });
    }

    /*
    @After
    public void dropTable() throws SQLException {
        transmiterRepository.dropDatatable();
    }
    */
}