package com.testing;

import java.sql.*;

/**
 * @author Artem Karnov @date 22.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class Jdbc {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mydb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "214189";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet res = null;

    public static void main(String[] args) {
        String sql = "SELECT * FROM User";
        String insert = "INSERT INTO MyTable (Id,Name,SecondName) VALUE(2,'Not','Karnov')";

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();

            res = stmt.executeQuery(sql);

            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString(2);
                String secondName = res.getString(3);
                String email = res.getString(4);
                String password = res.getString(5);
                System.out.println(id + " " + name + " " + secondName + " " + email + " " + password);
                System.out.println();
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                conn.close();
            } catch (SQLException se) {
                System.out.println("Error in connection closing! ");
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                System.out.println("Error in statment closing! ");
            }
            try {
                res.close();
            } catch (SQLException se) {
                System.out.println("Error in recources closing! ");
            }
            System.out.println("Goodbye!");
        }
    }
}
