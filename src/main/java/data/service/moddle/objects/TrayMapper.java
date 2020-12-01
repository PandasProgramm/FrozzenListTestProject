package data.service.moddle.objects;

import data.freezer.Tray;
import model.AbstractMapper;
import model.DataBaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 * TODO : WORKING ON THE DATABASESTRUCTURE
 */
public class TrayMapper extends AbstractMapper<Tray> {
    protected TrayMapper() throws SQLException{
        super("trays");
        createTable();
    }

    @Override
    public Tray convert(ResultSet resultSet) throws SQLException {
        Tray tray= new Tray();
        tray.setTrayID(resultSet.getInt("trayId"));
        return tray;
    }
    @Override
    public List<Tray> findAll(int start, int num) throws SQLException {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean createTable() throws SQLException {
        final String sql = "CREATE TABLE IF NOT EXISTS Tray("
                          +"trayID INTEGER PRIMARY KEY AUTOINCREMENT,"
                          +"PRODUCTS VARCHAR";
        try(Connection DBH= DataBaseConnector.get(); Statement statement= DBH.createStatement()){
            return  statement.executeUpdate(sql)>0;
        }
    }

}
