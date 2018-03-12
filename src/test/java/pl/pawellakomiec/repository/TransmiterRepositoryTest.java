package pl.pawellakomiec.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.pawellakomiec.domain.Transmiter;
import pl.pawellakomiec.repository.TransmiterRepository;
import pl.pawellakomiec.repository.TransmiterRepositoryFactory;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TransmiterRepositoryTest {

    TransmiterRepository transmiterRepository;

    @Before
    public void init_db() {
        transmiterRepository.initDatabase();

        transmiterRepository = TransmiterRepositoryFactory.getInstance();
        Transmiter transmiter1 = new Transmiter();
        Transmiter transmiter2 = new Transmiter();
        Transmiter transmiter3 = new Transmiter();
        Transmiter transmiter4 = new Transmiter();

        transmiter1.setId(1);
        transmiter1.setName("transmiter1");
        transmiter1.setPrice(100);

        transmiter2.setId(2);
        transmiter2.setName("transmiter2");
        transmiter2.setPrice(200);

        transmiter3.setId(3);
        transmiter3.setName("transmiter3");
        transmiter3.setPrice(300);

        transmiter4.setId(4);
        transmiter4.setName("transmiter4");
        transmiter4.setPrice(400);

        transmiterRepository.addTransmiter(transmiter1);
        transmiterRepository.addTransmiter(transmiter2);
        transmiterRepository.addTransmiter(transmiter3);
        transmiterRepository.addTransmiter(transmiter4);
    }


    @Test
    public void say_hello(){
        String message = "Hello";
        assertEquals("Message: ", message);
    }

    @Test
    public void get_all(){
        assertNotNull(transmiterRepository.getAll());
    }

    @Test
    public void create_transmiter(){
        Transmiter transmiter5 = new Transmiter();
        transmiter5.setId(5);
        transmiter5.setName("create - transmiter5");
        transmiter5.setPrice(50);
        transmiterRepository.addTransmiter(transmiter5);
        assertNotNull(transmiterRepository.getById(transmiter5.getId()));
    }

    @Test
    public void delete_transmiter(){
        Transmiter transmiter3 = transmiterRepository.getById(3);
        transmiterRepository.deleteTransmiter(transmiter3);
        if (transmiterRepository.getAll().size() > 0){
            assertNotNull(transmiterRepository.getAll());
        }else{
            assertNull(transmiterRepository.getById(transmiter3.getId()));
        }
    }

    @Test
    public void search_transmiter(){
        Long idToFind = (long) 1;
        assertNotNull(transmiterRepository.getById(idToFind));
    }

    @Test
    public void update_transmiter() {
        Transmiter transmiter2 = new Transmiter();
        int updateId = 1;
        transmiter2.setId(22);
        transmiter2.setName("transmiter222");
        transmiter2.setPrice(222);
        transmiterRepository.updateTransmiter(updateId, transmiter2);
        assertEquals(transmiterRepository.getById(updateId).getName(), transmiter2.getName());

        for(Transmiter transmiter1 : transmiterRepository.getAll()){
            assertNotNull(transmiter1.getName(), transmiter2.getName());
        }
    }

    @After
    public void drop_table(){
        TransmiterRepositoryFactory.getInstance().dropTransmiterTable();
        assertEquals(null, TransmiterRepositoryFactory.getInstance().getAll());
    }
}


