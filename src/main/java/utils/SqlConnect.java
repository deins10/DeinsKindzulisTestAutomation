package utils;

import java.sql.*;

public class SqlConnect {
    public static Connection connect() throws SQLException {
        // db parameters
        String url = "jdbc:sqlite:C:\\Users\\dreismanel\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";
        // create a connection to the database
        return DriverManager.getConnection(url);
    }

//    Statement stmt = connection.createStatement();
//
//    ResultSet rs = stmt.executeQuery("SELECT *\n" +
//            "FROM Customer c \n" +
//            "ORDER BY CustomerId  DESC \n" +
//            "LIMIT 1;");
//
//        while (rs.next()) {
//        //Display values
//        System.out.print("CustomerID: " + rs.getInt("CustomerId"));
//        System.out.print(", Name: " + rs.getString("FirstName"));
//        System.out.print(", Surname: " + rs.getString("LastName"));
//        System.out.println("\n");
//    }

    public static void main(String[] args) throws SQLException {
        Connection connection = connect();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Artist");

        while (rs.next()) {
            //Display values
            System.out.print("ID: " + rs.getInt("ArtistId"));
            System.out.print(", Name: " + rs.getString("Name"));
            System.out.println("\n");
        }
    }

}
