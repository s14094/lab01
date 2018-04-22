package pl.pawellakomiec.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TransmiterTest {

    private Transmiter transmiter;

    @Before
    public void buildTransmiter() {
        transmiter = new Transmiter();
    }

    @Test
    public void checkIfTransmiterExists() {
        assertNotNull(transmiter);
    }
}
