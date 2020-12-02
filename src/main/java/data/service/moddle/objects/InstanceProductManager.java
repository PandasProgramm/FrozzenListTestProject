package data.service.moddle.objects;

import data.Product.Product;
import data.Product.ProductTyp;
import data.service.model.AbstractMapper;
import data.service.model.DataBaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.function.Supplier;

/**
 * Created by  on 18.11.2020
 * TODO : WORKING ON THE DATABASESTRUCTURE
 */
public class InstanceProductManager extends AbstractMapper<Product> {


    protected InstanceProductManager()throws SQLException{
        super("instanceProductManager");
        createTable();
    }

    @Override
    public Product convert(ResultSet resultSet) throws SQLException {
        Product product= new Product();
        product.setId(resultSet.getInt("productId"));
        product.setMark(resultSet.getString("mark"));
        ProductTyp value= product.getProductTyp();
        String productTyp= value.name();
        product.setProductTyp(ProductTyp.valueOf(resultSet.getString(productTyp)));
        product.setAmount(resultSet.getDouble("amount"));
        product.setFreezingDate((Supplier<LocalDate>) resultSet.getDate("freezingDate"));
        product.setExpirationDate((Supplier<LocalDate>) resultSet.getDate("expirationDate"));
        return product;
    }

    @Override
    public boolean createTable() throws SQLException {
        final String sql= "CREATE TABLE IF NOT EXIST instanceProductManager("+
                          "productID INTEGER PRIMARYKEY,AUTOINCREMENT"+
                          "PRODUCTNAME STRING VARCHAR(),NOT NULL"
                         +"MARK STRING VARCHAR(),NOT NULL"
                         +"AMOUNT DOUBLE,NOT NULL"
                         +"FREEZINGDATE DATE,NOT NULL"
                         +"EXPIRATIONDATE DATE,NOT NULL)";
        try(Connection connection= DataBaseConnector.get();
            Statement statement= connection.createStatement()){
            return statement.executeUpdate(sql)>0;
        }

    }
}
