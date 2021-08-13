package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

    private static DBConnectionProvider instance = new DBConnectionProvider();
    private final String DB_URL = "jdbc:mysql://localhost:3306/sport_user?serverTimezone=UTC&characterEncoding=UTF-8";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "root";
    private Connection connection;

    private DBConnectionProvider(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static DBConnectionProvider getInstance(){
        return instance;
    }
    public Connection getConnection(){
        try {
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
