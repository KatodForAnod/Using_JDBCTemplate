package DAO;

import Model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class UserDAO implements Database {
    private final JdbcTemplate jdbcTemplate;

    //TODO Dependency Injection
    public UserDAO() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:4444/2ndLab");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("12345678");

        this.jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM Users", new UserMapper());
    }

    @Override
    public boolean addUser(String... properties) {
        try {
            jdbcTemplate.update("INSERT INTO Users VALUES (?, ?)", Integer.parseInt(properties[0]), properties[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Must be 2 fields");
            return false;
        } catch (NumberFormatException e){
            System.out.println("First field must be int");
            return false;
        }

        return true;
    }
}
