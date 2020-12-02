package data.service.model;

/**
 * Created by  on 02.12.2020
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public interface Mapper<T extends AbstractEntity> {
    //CRUD
    T findOneByID(int id) throws SQLException;
    List<T>findAll()throws SQLException;
    List<T>findAll(int start, int num)throws SQLException;

    boolean save(T t)throws SQLException;
    boolean delete(T t) throws SQLException;
    boolean delete(int id) throws SQLException;


    T convert(ResultSet resultSet) throws SQLException;
    boolean createTable() throws SQLException;
}
