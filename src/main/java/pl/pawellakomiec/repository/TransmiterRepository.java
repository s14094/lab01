package pl.pawellakomiec.repository;

import pl.pawellakomiec.domain.Transmiter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TransmiterRepository {

    Connection getConnection();

    void setConnection(Connection connection) throws SQLException;

    List<Transmiter> getAll() throws SQLException;

    Transmiter getById(int id) throws SQLException;

    void addTransmiter(Transmiter transmiter);

    void deleteTransmiter(Transmiter transmiter) throws SQLException;

    void updateTransmiter(int id, Transmiter newTransmiter) throws SQLException;

    void dropDatatable() throws SQLException;
}