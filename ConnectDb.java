package asimulatorsystem;

import java.sql.*;

public class ConnectDb {

    public Connection connection;
    public Statement statement;

    public ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "root");
            statement = connection.createStatement();

        } catch (Exception e) {
           
        }
    }
}
