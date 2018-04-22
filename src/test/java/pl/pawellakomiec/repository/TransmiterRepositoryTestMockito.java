package pl.pawellakomiec.repository;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.pawellakomiec.domain.Transmiter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TransmiterRepositoryTestMockito {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    TransmiterRepository transmiterRepository;
    @Mock
    Connection connectionMock;
    @Mock
    PreparedStatement insertStatementMock;
    @Mock
    PreparedStatement selectStatementMock;

    @Before
    public void initRepository() throws SQLException {

        when(connectionMock.prepareStatement("INSERT INTO Transmiter (name, price, power) VALUES (?, ?, ?)"))
                .thenReturn(insertStatementMock);
        when(connectionMock.prepareStatement("SELECT * FROM Transmiter"))
                .thenReturn(selectStatementMock);
        when(connectionMock.prepareStatement("SELECT * FROM Transmiter WHERE id = ?"))
                .thenReturn(selectStatementMock);
        when(connectionMock.prepareStatement("DROP TABLE Transmiter"))
                .thenReturn(selectStatementMock);
        when(connectionMock.prepareStatement("UPDATE Transmiter SET name = ? WHERE id = ?"))
                .thenReturn(selectStatementMock);
        when(connectionMock.prepareStatement("DELETE FROM Transmiter WHERE id = ?"))
                .thenReturn(selectStatementMock);
        transmiterRepository = new TransmiterRepositoryImpl(connectionMock);
        transmiterRepository.setConnection(connectionMock);
        verify(connectionMock).prepareStatement("INSERT INTO Person (name, yob) VALUES (?, ?)");
        verify(connectionMock).prepareStatement("SELECT id, name, yob FROM Person");
        verify(connectionMock.prepareStatement("SELECT * FROM Transmiter WHERE id = ?"));
        verify(connectionMock.prepareStatement("DROP TABLE Transmiter"));
        verify(connectionMock.prepareStatement("UPDATE Transmiter SET name = ? WHERE id = ?"));
        verify(connectionMock.prepareStatement("DELETE FROM Transmiter WHERE id = ?"));

    }

    @Test
    public void create_transmiter() throws SQLException {

        when(insertStatementMock.executeUpdate()).thenReturn(1);

        Transmiter transmiter5 = new Transmiter();
        transmiter5.setName("createtransmiter5");
        transmiter5.setPrice(50);
        transmiter5.setPower(30);
        transmiterRepository.addTransmiter(transmiter5);
        assertNotNull(transmiterRepository.getById(transmiter5.getId()));

        verify(insertStatementMock, times(1)).setString(1, "createtransmiter5");
        verify(insertStatementMock, times(1)).setInt(2, 50);
        verify(insertStatementMock, times(1)).setInt(3, 30);
        verify(insertStatementMock).executeUpdate();
    }

    @Test
    public void get_all() throws SQLException {
        assertNotNull(transmiterRepository.getAll());
    }

    @Test
    public void delete_transmiter() throws SQLException {
        Transmiter transmiter3 = transmiterRepository.getById(3);
        transmiterRepository.deleteTransmiter(transmiter3);
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

    @After
    public void dropTable() throws SQLException {
        transmiterRepository.dropDatatable();
    }
}