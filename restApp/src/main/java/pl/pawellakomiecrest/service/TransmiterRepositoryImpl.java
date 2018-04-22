package pl.pawellakomiecrest.service;

import org.springframework.stereotype.Component;
import pl.pawellakomiecrest.domain.Transmiter;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


@Component
public class TransmiterRepositoryImpl implements TransmiterRepository {

    private Connection connection;
    private PreparedStatement addTransmiterStmt;
    private PreparedStatement getAllStmt;
    private PreparedStatement getByIdStmt;
    private PreparedStatement deleteTableStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement deleteByIdStmt;


    public TransmiterRepositoryImpl(Connection connection) throws SQLException {
        this.connection = connection;
        if (!isDatabaseReady()) {
            createTables();
        }
        this.setConnection(this.connection);

    }

    public TransmiterRepositoryImpl() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
        if (!isDatabaseReady()) {
            createTables();
        }
        this.setConnection(this.connection);

    }

    public void createTables() throws SQLException {
        connection.createStatement().executeUpdate(
                "CREATE TABLE "
                        + "Transmiter(id int GENERATED BY DEFAULT AS IDENTITY, " +
                        "name varchar(20) NOT NULL)");
    }

    public boolean isDatabaseReady() {
        try {
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            boolean tableExists = false;
            while (rs.next()) {
                if ("Transmiter".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }
            return tableExists;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Transmiter> getAll() {
        List<Transmiter> transmiters = new LinkedList<>();
        try {
            ResultSet results = getAllStmt.executeQuery();

            while (results.next()) {
                Transmiter u = new Transmiter();
                u.setId(results.getInt("id"));
                u.setName(results.getString("name"));
                transmiters.add(u);
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        return transmiters;
    }

    @Override
    public Transmiter getById(int id) throws SQLException {
        getByIdStmt.setInt(1, id);
        ResultSet results = getByIdStmt.executeQuery();
        if (results.next()) {
            Transmiter transmiter = new Transmiter();
            transmiter.setId(results.getInt("id"));
            transmiter.setName(results.getString("name"));
            return transmiter;
        } else {
            return null;
        }
    }


    @Override
    public int addTransmiter(Transmiter transmiter) {
        try {
            addTransmiterStmt.setString(1, transmiter.getName());
            return addTransmiterStmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
    }

    @Override
    public int deleteTransmiter(Transmiter transmiter) throws SQLException {

        deleteByIdStmt.setInt(1, transmiter.getId());
        return deleteByIdStmt.executeUpdate();
    }

    @Override
    public void updateTransmiter(int id, Transmiter newTransmiter) throws SQLException {

        updateStmt.setInt(2, id);
        updateStmt.setString(1, newTransmiter.getName());
        updateStmt.executeUpdate();

    }

    @Override
    public void dropDatatable() throws SQLException {
        deleteTableStmt.executeUpdate();
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        addTransmiterStmt = connection.prepareStatement("INSERT INTO Transmiter (name) VALUES (?)");
        getAllStmt = connection.prepareStatement("SELECT * FROM Transmiter");
        getByIdStmt = connection.prepareStatement("SELECT * FROM Transmiter WHERE id = ?");
        deleteTableStmt = connection.prepareStatement("DROP TABLE Transmiter");
        updateStmt = connection.prepareStatement("UPDATE Transmiter SET name = ? WHERE id = ?");
        deleteByIdStmt = connection.prepareStatement("DELETE FROM Transmiter WHERE id = ?");
    }

}