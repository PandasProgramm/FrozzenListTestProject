package data.service.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public final class DataBaseConnector {

    private  DataBaseConnector(){

    }

    public static Connection get() throws SQLException{
        String url= "jdbc:sqlite:myData.db";
        return DriverManager.getConnection(url);
    }
}