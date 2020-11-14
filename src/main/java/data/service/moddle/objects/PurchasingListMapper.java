package data.service.moddle.objects;

import data.purchasing.list.PurchasingList;
import data.service.moddle.AbstractMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public class PurchasingListMapper extends AbstractMapper<PurchasingList> {

    protected PurchasingListMapper() {
        super("purchasingLists");
    }

    @Override
    public PurchasingList findOneByID(int id) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PurchasingList convert(ResultSet resultSet) throws SQLException {

    }

    @Override
    public List<PurchasingList> findAll(int start, int num) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean createTable() throws SQLException {

    }

    @Override
    public boolean delete(PurchasingList purchasingList) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(PurchasingList purchasingList) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean insert(PurchasingList purchasingList) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
