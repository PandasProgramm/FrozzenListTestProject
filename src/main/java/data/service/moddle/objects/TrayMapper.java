package data.service.moddle.objects;

import data.freezer.Tray;
import data.service.moddle.AbstractMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public class TrayMapper extends AbstractMapper<Tray> {
    protected TrayMapper() {
        super("trays");
    }

    @Override
    public Tray findOneByID(int id) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Tray convert(ResultSet resultSet) throws SQLException {

    }

    @Override
    public List<Tray> findAll(int start, int num) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean createTable() throws SQLException {

    }

    @Override
    public boolean delete(Tray tray) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Tray tray) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean insert(Tray tray) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
