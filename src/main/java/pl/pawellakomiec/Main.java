package pl.pawellakomiec;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@EnableAutoConfiguration
public class Main extends SpringBootServletInitializer {

    public static void main(String[] args) throws SQLException, DatabaseUnitException, IOException {
        SpringApplication.run(Main.class, args);

        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        FlatXmlDataSet.write(connection.createDataSet(),
                new FileOutputStream("src/test/resources/databaseDump.xml"));
        FlatDtdDataSet.write(connection.createDataSet(),
                new FileOutputStream("src/test/resources/databaseDump.dtd"));
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }
}