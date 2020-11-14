package data.service.moddle.objects;

import data.freezer.Freezer;
import data.service.moddle.AbstractMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public class FreezerMapper extends AbstractMapper<Freezer> {

    protected FreezerMapper() {
        super("freezers");
    }

    @Override
    public Freezer findOneByID(int id) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Freezer convert(ResultSet resultSet) throws SQLException {

    }

    @Override
    public List<Freezer> findAll(int start, int num) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean createTable() throws SQLException {

    }

    @Override
    public boolean delete(Freezer freezer) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Freezer freezer) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean insert(Freezer freezer) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
