package pl.pawellakomiec.repository;

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
        transmiter1.setName("trasmiter1");
        transmiter1.setPrice(100);

        transmiter2.setId(2);
        transmiter2.setName("trasmiter2");
        transmiter2.setPrice(200);

        transmiter3.setId(3);
        transmiter3.setName("trasmiter3");
        transmiter3.setPrice(300);

        transmiter4.setId(4);
        transmiter4.setName("trasmiter4");
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
    public void delete_trasmiter(){
        Transmiter transmiter3 = transmiterRepository.getById(3);
        transmiterRepository.deleteTransmiter(transmiter3);
        if (transmiterRepository.getAll().size() > 0){
            assertNotNull(transmiterRepository.getAll());
        }else{
            assertNull(transmiterRepository.getById(transmiter3.getId()));
        }
    }

    @Test
    public void search_trasmiter(){
        Long idToFind = (long) 1;
        assertNotNull(transmiterRepository.getById(idToFind));
    }

    @Test
    public void update_trasmiter() {
        Transmiter transmiter2 = new Transmiter();
        transmiter2.setId(22);
        transmiter2.setName("transmiter222");
        transmiter2.setPrice(222);
        long transmiterToUpdate = 1;
        transmiterRepository.updateTransmiter(transmiterToUpdate, transmiter2);
        assertEquals(transmiterRepository.getById(transmiterToUpdate).getName(), transmiter2.getName());

        for(Transmiter transmiter1 : transmiterRepository.getAll()){
            //if(transmiter2.getId().equals(transmiterToUpdate)){
                assertNotNull(transmiter1.getName(), transmiter2.getName());
            //}
        }

    }
}


