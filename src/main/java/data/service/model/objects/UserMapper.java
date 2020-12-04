package data.service.model.objects;

import data.user.User;
import data.service.model.AbstractMapper;
import data.service.model.DataBaseConnector;

import java.lang.reflect.Field;
import java.sql.*;


/**
 * Created by Miguel Gutierrez on 13.11.2020
 * TODO : WORKING ON THE DATABASESTRUCTURE
 */
public class UserMapper extends AbstractMapper<User> {


    public UserMapper()throws SQLException {
        super("users");
        createTable();
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
    public boolean createTable() throws SQLException {
        final String sql= "CREATE TABLE IF NOT EXISTS users("
                +"userId INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"USERNAME VARCHAR(20) NOT NULL,"
                +"PASSWORD VARCHAR(15) NOT NULL,"
                +"freezerID INTEGER,"
                +"FOREIGN KEY(freezerID) REFERENCES freezers(freezerID)"
                + ") ";
        try(Connection DBH= DataBaseConnector.get(); Statement statement= DBH.createStatement()){
            return  statement.executeUpdate(sql)>0;
        }
    }

    @Override
    public boolean save(User user) throws SQLException {
        //INSERT INTO users (firstname, lastname) VALUES('Peter', 'Parker')
        StringBuilder fields = new StringBuilder();
        StringBuilder values = new StringBuilder();

        //Eigenschaften der Elternklasse abfragen wenn id mitbenutzt werden soll
//        Field[] superFields = t.getClass().getSuperclass().getDeclaredFields();

        //Eigenschaften der Klasse abfragen
        for (Field f : user.getClass().getDeclaredFields()) {
            if (f.getName().equals("serialVersionUID")) {
                continue;
            }
            if(f.getName().equals("freezer"))continue;
            if (fields.length() > 0) {
                fields.append(",");
                values.append(",");
            }

            fields.append(f.getName()); //Name der Eigenschaft
            values.append("?"); //Name der Eigenschaft
        }
        String sql = "INSERT INTO " + TABLE + " (" + fields.toString() + ") VALUES(" + values.toString() + ")";

        return executePrepared(sql, user);
    }
}
