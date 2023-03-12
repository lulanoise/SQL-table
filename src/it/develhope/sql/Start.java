package it.develhope.sql;
import java.sql.*;

public class Start {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "524013659?Ln");

        String query1 = "CREATE DATABASE newdb";
        statement = connection.createStatement();
        statement.execute(query1);

        String query2 = "USE newdb";
        statement = connection.createStatement();
        statement.execute(query2);

        System.out.println(connection != null);

        String query3 = "CREATE TABLE IF NOT EXISTS students (student_id INT(10) NOT NULL AUTO_INCREMENT , last_name VARCHAR(30), first_name VARCHAR(30), CONSTRAINT student_pk PRIMARY KEY (student_id))";

        statement.execute(query3);

      String[] query4 = {"INSERT INTO students (last_name, first_name) VALUES ('Potter','Harry')",
                "INSERT INTO students (last_name, first_name) VALUES ('Granger','Hermione')",
                "INSERT INTO students (last_name, first_name) VALUES ('Weasley','Ron')",
                "INSERT INTO students (last_name, first_name) VALUES ('Weasley','Ginny')"};

            for (String query : query4) {
                statement.execute(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }
}
