package sample.proyectoloteria.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final static String HOST = "localhost";
    private final static String PORT = "3306";
    private final static String DB_NAME = "test";
    private final static String USER = "root";
    private final static String SECRET = "secret";

    public static Connection connection;

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(
            "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, USER, SECRET
            );

            System.out.println("\uD83D\uDE80 DB connected");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
