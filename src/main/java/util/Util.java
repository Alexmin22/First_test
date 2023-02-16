package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    private static final String USER = "root";
    private static final String PASSWORD = "Gfrhjdcrbq63505";
    private static final String URL = "jdbc:mysql://localhost:3306/user";

    private Util() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("No connection");
            e.printStackTrace();
        }
        return null;
    }
}
