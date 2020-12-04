package data.service.model.objects;

import data.freezer.Tray;
import data.service.model.AbstractMapper;
import data.service.model.DataBaseConnector;

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
    protected TrayMapper() {
        super("trays");
        try{
            createTable();
        }catch (SQLException sqlException){
            //TODO: message
        }
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
        final String sql = "CREATE TABLE IF NOT EXISTS tray("
                          +"trayId INTEGER PRIMARY KEY AUTOINCREMENT,"
                          +"PRODUCTID INTEGER,"
                          +"FOREIGN KEY(productId) REFERENCES product(productId),";
        try(Connection DBH= DataBaseConnector.get(); Statement statement= DBH.createStatement()){
            return  statement.executeUpdate(sql)>0;
        }
    }

}
