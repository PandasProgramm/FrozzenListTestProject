package data.service.moddle.objects;

import data.freezer.Freezer;
import model.AbstractMapper;
import model.DataBaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 *
 *TODO : WORKING ON THE DATABASESTRUCTURE
 */
public class FreezerMapper extends AbstractMapper<Freezer> {

    public FreezerMapper() {
        super("freezers");
    }


    @Override
    public Freezer convert(ResultSet resultSet) throws SQLException {
        Freezer freezer= new Freezer();
        freezer.setFreezerId(resultSet.getInt("freezerId"));
        freezer.setName(resultSet.getString("name"));
        //freezer.setTrays(resultSet.getArray(Arrays.toString(freezer.getTrays())));
        return freezer;
    }
    @Override
    public List<Freezer> findAll(int start, int num) throws SQLException {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean createTable() throws SQLException {
        final String sql = "CREATE TABLE IF NOT EXISTS freezers"
                         + "freezerId INTEGER PRIMARY KEY AUTOINCREMENT("
                         + "NAME STRING VARCHAR(15) NOT NULL,";
                      //    + "TRAYS "   ;
        try(Connection connection= DataBaseConnector.get(); Statement statement= connection.createStatement()){
            return statement.executeUpdate(sql)>0;
        }
    }
}
