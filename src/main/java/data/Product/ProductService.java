package data.Product;

import data.service.General_I;

import java.io.*;
import java.util.TreeSet;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 *
 * All settings for product
 */
public class ProductService implements General_I<Product> {

    private static final String DATA_FILE_PRODUCT="product.db";
    TreeSet<Product>products= new TreeSet<>();

    /**
     *
     * @param product add to a product list
     */
    @Override
    public void add(Product product) {
    products.add(product);
    saveToFile();
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
        saveToFile();
    }

    /**
     * save the product data
     */
    @Override
    public void saveToFile() {
        try(ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream(DATA_FILE_PRODUCT))){
            objectOutputStream.writeObject(products);
        }catch (IOException e){
            //TODO: set message
        }
    }
    /**
     * load the product data
     */
    @Override
    public void readFromFile() {
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(DATA_FILE_PRODUCT))){
            products=(TreeSet<Product>) objectInputStream.readObject();
        }catch (IOException|ClassNotFoundException exception){
            products= new TreeSet<>();
        }
    }
}
