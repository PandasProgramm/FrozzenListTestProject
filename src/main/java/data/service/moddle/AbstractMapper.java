package data.service.moddle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public abstract class AbstractMapper<T>implements Mapper<T> {

    protected final String TABLE;

    protected AbstractMapper(String table){
        this.TABLE=table;
    }

    @Override
    public List<T> findAll() throws SQLException {
        List<T>list= new ArrayList<>();
        try(Connection dataBase= DataBaseConnector.get();
        Statement statement= dataBase.createStatement()){
            ResultSet resultSet= statement.executeQuery("SELECT *FROM "+TABLE );
            while (resultSet.next())
            {
                list.add(convert(resultSet));
            }
        }return list;
    }
}
