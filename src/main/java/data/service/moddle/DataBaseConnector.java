package data.service.moddle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public class DataBaseConnector {

    private DataBaseConnector(){}

    public static Connection get()throws SQLException {
        final String url= "jdbc:sqlite:myFreezerApplication.db";
        return DriverManager.getConnection(url);
    }
}
