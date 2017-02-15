package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alea on 11/02/17.
 */
public class DataBaseConection {
    private static DataBaseConection instance = new DataBaseConection();

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static  String DB_URL;

    static  String USER;
    static  String PASS;

    public DataBaseConection(String DB_URL, String USER, String PASS ){
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PASS = PASS;
    }

    private DataBaseConection() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL,USER, PASS);
        } catch (SQLException e) {
            System.out.println("ERROR: No s'ha pogut conectar a la base de dades.");
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

}
