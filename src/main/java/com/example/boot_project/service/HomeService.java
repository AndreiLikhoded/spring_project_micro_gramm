package com.example.boot_project.service;

import com.example.boot_project.entity.User;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Service
public class HomeService {
    private Connection conn;

//    @Autowired
//    private final CustomerDao customerDao;
//
//
//    public HomeService(CustomerDao customerDao) {
//        this.customerDao = customerDao;
//    }
//
    private Connection getNewConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=qwerty";
        return DriverManager.getConnection(url);
    }

    public String getDataSourceConn() {
        DataSource dataSource = getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1)) {
                return "All is OK";
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private DataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setUsername("postgres");
        config.setPassword("qwerty");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        return new HikariDataSource(config);
    }


    private void init() throws SQLException {
        conn = getNewConnection();
    }

    public String connect() {
        try {
            init();
            return "Good connection";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private int executeUpdate(String query) throws SQLException {
        init();
        Statement statement = conn.createStatement();
        int result = statement.executeUpdate(query);
        return result;
    }

    private void createCustomerTable() throws SQLException {
        String customerTableQuery = "create table customers (" +
                "id integer primary key," +
                "name varchar(40)," +
                "age integer)";
        String customerEntryQuery = "insert into customers(id, name, age)" +
                "values(73, 'Brian', 33)";

        executeUpdate(customerTableQuery);
        executeUpdate(customerEntryQuery);
    }

    public String shouldCreateTable() {
        try {
            createCustomerTable();
            conn.createStatement().execute("select * from customers");
            return "All is ok";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String shouldSelectData() {
        try {
            String query = "Select * from customers where name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "Brian");
            if (ps.execute()) {
                ResultSet resultSet = ps.getResultSet();
                resultSet.next();
                int age = resultSet.getInt("age");

                return String.format("Age %s", age);
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

//    public List<Customer> getCustomers() {
//        return customerDao.getCustomers();
//    }


    private void createUsersTable() throws SQLException {
        String userTableQuery = "create table users (" +
                "id integer primary key," +
                "name varchar(40)," +
                "age integer)";
        String userEntryQuery = "insert into users(id, name, age)" +
                "values(1, 'Andrei', 33)";

        executeUpdate(userTableQuery);
        executeUpdate(userEntryQuery);
    }
    public String shouldCreateUserTable(){
        try{
            createUsersTable();
            conn.createStatement().execute("select * from users");
            return "All is ok";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    private void createPublicationsTable() throws SQLException {
        String createTablequery = "create table publications (" +
                "id INTEGER PRIMARY KEY, " +
                "image TEXT, " +
                "description TEXT, " +
                "dataOfPublication timestamp)";
        executeUpdate(createTablequery);
    }

    private void createLikesTable() throws SQLException {
        String createTablequery = "create table likes (" +
                "id INTEGER PRIMARY KEY, " +
                "likeHolder INTEGER, " +
                "likeAim INTEGER, " +
                "dateOfLike timestamp)";
        executeUpdate(createTablequery);
    }

    private void createSubscribesTable() throws SQLException {
        String createTablequery = "create table subscribes (" +
                "id INTEGER PRIMARY KEY, " +
                "subscriberId INTEGER, " +
                "subscriberTo INTEGER, " +
                "dateSubscribe timestamp)";
        executeUpdate(createTablequery);
    }
    private void createCommentsTable() throws SQLException {
        String createTablequery = "create table comments (" +
                "id INTEGER PRIMARY KEY, " +
                "commentText varchar(40), " +
                "dateComment timestamp, " +
                "user INTEGER)";
        executeUpdate(createTablequery);
    }

    public String shouldCreatePublicationsCommentsLikesSubscribesTables(){
        try{
            createSubscribesTable();
            createLikesTable();
            createPublicationsTable();
            createCommentsTable();
            conn.createStatement().execute("select * from users");
            return "All is ok";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    public User findUserByProfile() {
        String profile = null;
        try {
            String SQL = "select * from users " + "where login =?";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(1, profile);

            if (statement.execute()) {
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();

                User user = new User();

                user.setLogin(resultSet.getString("login"));

                return user;
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public User findUserByName() {
        String profile = null;
        try {
            String SQL = "select * from users " + "where name =?";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(1, profile);

            if (statement.execute()) {
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();

                User user = new User();

                user.setName(resultSet.getString("name"));

                return user;
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public User findUserByEmail() {
        String profile = null;
        try {
            String SQL = "select * from users " + "where email =?";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setString(1, profile);

            if (statement.execute()) {
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();

                User user = new User();

                user.setEmail(resultSet.getString("email"));

                return user;
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return null;
        }
    }
}
