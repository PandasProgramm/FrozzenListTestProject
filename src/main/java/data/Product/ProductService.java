package data.Product;

import data.service.General_I;

import java.util.TreeSet;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 * All settings for product
 */
public class ProductService implements General_I<Product> {


    private static final String DATA_FILE_PRODUCT="product.db";
    TreeSet<Product>products;
    /**
     * @param product add to a product list
     */
    @Override
    public void add(Product product) {
    products.add(product);

    }

    /**
     *
     * @param product remove from the product list
     */
    @Override
    public void remove(Product product) {
        if(product.getPieces()>1){
            int pieces = product.getPieces()-1;
            product.setPieces(pieces);
        }
        products.remove(product);
    }
}
