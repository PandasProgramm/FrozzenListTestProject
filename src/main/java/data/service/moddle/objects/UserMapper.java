package data.service.moddle.objects;

import data.user.User;
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
public class UserMapper extends AbstractMapper<User> {


    public UserMapper() {
       super("users");
    }



    @Override
    public User convert(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("userId"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setFreezerID(resultSet.getInt("freezerID"));
        return user;
    }
    @Override
    public List<User> findAll(int start, int num) throws SQLException {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean createTable() throws SQLException {
        final String sql= "CREATE TABLE IF NOT EXISTS users("
                +"userId INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"USERNAME VARCHAR(20) NOT NULL,"
                +"PASSWORD VARCHAR(15) NOT NULL"
                +"freezerID INTEGER FOREIGN KEY AUTOINCREMENT)";
        try(Connection DBH= DataBaseConnector.get(); Statement statement= DBH.createStatement()){
            return  statement.executeUpdate(sql)>0;
        }
    }

}
