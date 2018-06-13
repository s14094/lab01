package pl.pawellakomiec.repository;

import org.springframework.stereotype.Component;
import pl.pawellakomiec.domain.Transmiter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        setConnection(connection);
    }

    public TransmiterRepositoryImpl() {

    }

    public Connection getConnection() {
        return connection;
    }


    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        addTransmiterStmt = connection.prepareStatement("INSERT INTO Transmiter (name,price,power) VALUES (?,?,?)");
        getAllStmt = connection.prepareStatement("SELECT * FROM Transmiter");
        getByIdStmt = connection.prepareStatement("SELECT * FROM Transmiter WHERE id = ?");
        deleteTableStmt = connection.prepareStatement("DROP TABLE Transmiter");
        updateStmt = connection.prepareStatement("UPDATE Transmiter SET name = ? WHERE id = ?");
        deleteByIdStmt = connection.prepareStatement("DELETE FROM Transmiter WHERE id = ?");
    }

//    public void setConnection(Connection connection) throws SQLException {
//        this.connection = connection;
//    }

    public void createTables() throws SQLException {
        connection.createStatement().executeUpdate(
                "CREATE TABLE " + "Transmiter(id int GENERATED BY DEFAULT AS IDENTITY, " +
                        "name varchar(30), " + "price int, " + "power int)");
    }

    public boolean isDatabaseReady() {
        try {
            ResultSet results = connection.getMetaData().getTables(null, null, null, null);
            boolean tableExists = false;
            while (results.next()) {
                if ("Transmiter".equalsIgnoreCase(results.getString("TABLE_NAME"))) {
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
                u.setPrice(results.getInt("price"));
                u.setPower(results.getInt("power"));

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
        int count = 0;
        try {
            addTransmiterStmt.setString(1, transmiter.getName());
            addTransmiterStmt.setInt(2, transmiter.getPower());
            addTransmiterStmt.setInt(3, transmiter.getPrice());
            count = addTransmiterStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
    }

    @Override
    public int deleteTransmiter(Transmiter transmiter) throws SQLException {

        deleteByIdStmt.setInt(1, transmiter.getId());
        deleteByIdStmt.executeUpdate();
        return 1;
    }

    @Override
    public void updateTransmiter(int id, Transmiter newTransmiter) throws SQLException {
        updateStmt.setInt(2, id);
        updateStmt.setString(1, newTransmiter.getName());
        updateStmt.executeUpdate();
    }

    @Override
    public void dropDatatable() throws SQLException {
        //deleteTableStmt.executeUpdate();
    }

}