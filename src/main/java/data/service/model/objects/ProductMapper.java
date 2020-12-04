package data.service.model.objects;

import data.Product.Product;
import data.service.model.AbstractMapper;
import data.service.model.DataBaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 * TODO : WORKING ON THE DATABASESTRUCTURE
 */
public class ProductMapper extends AbstractMapper<Product> {
    protected ProductMapper() {
        super("products");
        try
        {
            createTable();
        }catch (SQLException sqlException){
            //TODO: message
        }

    }


    @Override
    public Product convert(ResultSet resultSet) throws SQLException {
        Product product= new Product();
        product.setProductId(resultSet.getInt("productId"));
        //product.setProductTyp(resultSet.g);
        product.setMark(resultSet.getString("mark"));
        product.setAmount(resultSet.getDouble("amount"));
       // product.setDate(resultSet.getDate("freezingDate"));
        //product expirationDate
        return product;
    }

    @Override
    public boolean createTable() throws SQLException {
      final String sql=  "CREATE TABLE IF NOT EXISTS products("
                        +"productID INTEGER PRIMARY KEY AUTOINCREMENT,"
                        +"NAME STRING VARCHAR(),NOT NULL"
                        +"MARK STRING VARCHAR(),NOT NULL"
                        +"AMOUNT DOUBLE,NOT NULL"
                        +"FREEZINGDATE DATE,NOT NULL"
                        +"EXPIRATIONDATE DATE,NOT NULL)";
        try(Connection DBM= DataBaseConnector.get();
            Statement statement= DBM.createStatement()){
            return statement.executeUpdate(sql)>0;
        }
    }

}
