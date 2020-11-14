package data.service.moddle.objects;

import data.service.moddle.AbstractMapper;
import data.service.moddle.DataBaseConnector;
import data.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public class UserMapper extends AbstractMapper<User> {


    protected UserMapper() {
       super("users");
    }

    @Override
    public User findOneByID(int id) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User convert(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("userId"));
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
                +"PASSWORD VARCHAR(15) NOT NULL"                                  //passwort in der Informationstabelle?
                +"freezerID INTEGER FOREIGN KEY AUTOINCREMENT)";
        try(Connection DBH= DataBaseConnector.get(); Statement statement= DBH.createStatement()){
            return  statement.executeUpdate(sql)>0;
        }
    }
    @Override
    public boolean delete(User user) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(User user) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean insert(User user) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
