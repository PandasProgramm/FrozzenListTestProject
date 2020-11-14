package data.service.moddle.objects;

import data.Product.Product;
import data.service.moddle.AbstractMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 */
public class ProductMapper extends AbstractMapper<Product> {
    protected ProductMapper() {
        super("products");
    }

    @Override
    public Product findOneByID(int id) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product convert(ResultSet resultSet) throws SQLException {

    }

    @Override
    public List<Product> findAll(int start, int num) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean createTable() throws SQLException {

    }

    @Override
    public boolean delete(Product product) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Product product) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean insert(Product product) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
