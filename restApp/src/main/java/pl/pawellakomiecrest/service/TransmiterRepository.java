package pl.pawellakomiecrest.service;


import pl.pawellakomiecrest.domain.Transmiter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TransmiterRepository {

    List<Transmiter> getAll();

    Transmiter getById(int id) throws SQLException;

    int addTransmiter(Transmiter transmiter);

    int deleteTransmiter(Transmiter transmiter) throws SQLException;

    void updateTransmiter(int oldId, Transmiter newTransmiter) throws SQLException;

    void dropDatatable() throws SQLException;

    Connection getConnection();

    void setConnection(Connection connection) throws SQLException;

}
