package data.service.model;

/**
 * Created by  on 02.12.2020
 */


import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public abstract class AbstractMapper<T extends AbstractEntity> implements Mapper<T>{
    protected final String TABLE;

    protected AbstractMapper(String table) {
        this.TABLE = table;
    }
    @Override
    public List<T> findAll(int start, int num) throws SQLException {
        List<T> list = new ArrayList<>();
        final String sql = "SELECT* FROM " + TABLE + " COMPANY LIMIT ? OFFSET ";
        try (Connection dbh = DataBaseConnector.get();
             PreparedStatement statement = dbh.prepareStatement(sql)) {
            statement.setInt(1, num);
            statement.setInt(2, start);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(convert(resultSet));
            }
        }
        return list;
    }
    @Override
    public List<T> findAll() throws SQLException {

        List<T> list = new ArrayList<>();
        try (Connection dbh = DataBaseConnector.get();
             Statement statement = dbh.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE);
            while (resultSet.next()) {
                list.add(convert(resultSet));
            }
        }
        return list;
    }
    @Override
    public boolean delete(T t) throws SQLException {
        return delete(t.getId());
    }
    @Override
    public boolean delete(int id) throws SQLException {
        final String sql = "SELECT* FROM" + TABLE +
                "WHERE id";
        try (Connection connection = DataBaseConnector.get(); Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql) > 0;
        }
    }
    @Override
    public T findOneByID(int id) throws SQLException {
        final String sql = "SELECT *FROM" + TABLE + "WHERE id" + id;
        try (Connection connection = DataBaseConnector.get(); Statement statement = connection.createStatement()) {
            ResultSet resultSets = statement.executeQuery(sql);
            if (resultSets.next()) {
                return convert(resultSets);
            }
            return null;
        }
    }
    @Override
    public boolean save(T t) throws SQLException {
        if(t.getId()>0){
            return update(t);
        }
        else return insert(t);
    }
    private boolean insert(T t) throws SQLException{
        //INSERT INTO users (firstname, lastname) VALUES('Peter', 'Parker')
        StringBuilder fields = new StringBuilder();
        StringBuilder values = new StringBuilder();

        //Eigenschaften der Elternklasse abfragen wenn id mitbenutzt werden soll
//        Field[] superFields = t.getClass().getSuperclass().getDeclaredFields();

        //Eigenschaften der Klasse abfragen
        for (Field f : t.getClass().getDeclaredFields()) {
            if (f.getName().equals("serialVersionUID")) {
                continue;
            }
            if (fields.length() > 0) {
                fields.append(",");
                values.append(",");
            }

            fields.append(f.getName()); //Name der Eigenschaft
            values.append("?"); //Name der Eigenschaft
        }
        String sql = "INSERT INTO " + TABLE + " (" + fields.toString() + ") VALUES(" + values.toString() + ")";

        return executePrepared(sql, t);
    }
    private  boolean executePrepared(String sql, T t)throws SQLException{
        try(Connection connection= DataBaseConnector.get();PreparedStatement statement= connection.prepareStatement(sql)){
            int i=0;
            for(Field f:t.getClass().getDeclaredFields()) {
                if (f.getName().equals("serialVersionUID")) continue;
                f.setAccessible(true);//macht private eigenschaften lesbar
                try {
                    statement.setObject(++i, f.get(t));//Frage feld f aus dem Objekt t ab
                } catch (IllegalAccessException e) {
                    //TODO:message
                }
            }
            statement.execute();
            return statement.getUpdateCount()>0;
        }
    }
    private boolean update(T t) throws SQLException {
        StringBuilder fields = new StringBuilder();

        for (Field f : t.getClass().getDeclaredFields()) {
            if (f.getName().equals("serialVersionUID")) {
                continue;
            }
            if (fields.length() > 0) {
                fields.append(",");
            }
            fields.append(f.getName()).append(" = ?");
        }

        String sql = "UPDATE " + TABLE + " SET " + fields.toString() + " WHERE id = " + t.getId();
        return executePrepared(sql, t);
    }
}
