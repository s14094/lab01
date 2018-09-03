package pl.pawellakomiec.repository;


import pl.pawellakomiec.domain.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface PersonRepository {
    Connection getConnection();

    void setConnection(Connection connection) throws SQLException;

    int addPerson(Person person);

    int deletePerson(Person person);

    int updatePerson(Person person) throws SQLException;

    Person getPerson(long id) throws SQLException;

    String introduceSelf();

    int deleteAll();

    List<Person> getAllPersons();
}