package data.freezer;

import data.Product.Product;
import data.Product.ProductService;
import data.Product.ProductTyp;

import java.util.*;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */
public class Tray {

    private final int iD;
    private final Map<ProductTyp, ProductService> products= new TreeMap<>();

    /**
     *
     * @param numberOfTray from a freezer. Create trays for number of trays
     */
    public Tray(int numberOfTray){
        products.put(ProductTyp.VEGETABLES,new ProductService());
        products.put(ProductTyp.PORK,new ProductService());
        products.put(ProductTyp.BEEF,new ProductService());
        products.put(ProductTyp.POULTRY,new ProductService());
        products.put(ProductTyp.CALF,new ProductService());
        products.put(ProductTyp.LAMB,new ProductService());
        products.put(ProductTyp.FRUIT,new ProductService());
        products.put(ProductTyp.ICE,new ProductService());
        products.put(ProductTyp.SAUCES,new ProductService());
        products.put(ProductTyp.MEALS,new ProductService());
        products.put(ProductTyp.PIZZA,new ProductService());
        products.put(ProductTyp.OTHER,new ProductService());
        iD=numberOfTray;
    }

    /**
     *
     * @return the id of the tray
     */
    public int getID() {
        return iD;
    }


    @Override
    public boolean equals(Object o) {
    if(this==o)return true;
    if(!(o instanceof Product))return false;
    Tray tray= (Tray)o;
    if(iD==tray.iD)return true;
    return false;
    }
    @Override
    public int hashCode() {
        return this.iD;
    }
}
