package pl.pawellakomiec.repository;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TransmiterRepositoryFactory {

    public static TransmiterRepository getInstance() {

        try {
            String url = "jdbc:hsqldb:hsql://localhost/workdb";
            return new TransmiterRepositoryImpl(DriverManager.getConnection(url));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
