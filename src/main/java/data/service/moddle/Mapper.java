package data.service.moddle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 * data base service to find data objectives from data base for manipulation
 */
public interface Mapper<T> {

    T findOneByID(int id)throws SQLException;
    T convert(ResultSet resultSet)throws SQLException;

    List<T> findAll()throws SQLException;
    List<T>findAll(int start, int num)throws SQLException;

    boolean createTable()throws SQLException;
    boolean delete(T t)throws SQLException;
    boolean update(T t)throws SQLException;
    boolean insert(T t)throws SQLException;
}
