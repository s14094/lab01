package pl.pawellakomiec.repository;

import pl.pawellakomiec.domain.Transmiter;

import java.sql.SQLException;
import java.util.List;

public interface TransmiterRepository {

    public List<Transmiter> getAll();

    public Transmiter getById(int id) throws SQLException;

    public void addTransmiter(Transmiter transmiter);

    public void deleteTransmiter(Transmiter transmiter) throws SQLException;;

    public void updateTransmiter(int id, Transmiter newTransmiter) throws SQLException;;

    public void dropTransmiterTable() throws SQLException;
}