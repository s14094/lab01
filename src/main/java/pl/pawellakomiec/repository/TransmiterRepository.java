package pl.pawellakomiec.repository;

import pl.pawellakomiec.domain.Transmiter;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

public interface TransmiterRepository {

    public void setConnection(Connection connection) throws SQLException;

    public Connection getConnection();

    public List<Transmiter> getAll() throws SQLException;

    public Transmiter getById(int id) throws SQLException;

    public void addTransmiter(Transmiter transmiter);

    public void deleteTransmiter(Transmiter transmiter) throws SQLException;;

    public void updateTransmiter(int id, Transmiter newTransmiter) throws SQLException;;

    public void dropTransmiterTable() throws SQLException;
}