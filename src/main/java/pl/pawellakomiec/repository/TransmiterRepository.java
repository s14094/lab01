package pl.pawellakomiec.repository;

import pl.pawellakomiec.domain.Transmiter;

import java.util.List;

public interface TransmiterRepository {

    public void initDatabase();
    public List<Transmiter> getAll();
    public Transmiter getById(long id);

    public void addTransmiter(Transmiter transmiter);
    public void deleteTransmiter(Transmiter transmiter);
    public void updateTransmiter(long id, Transmiter newTransmiter);

}