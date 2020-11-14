package data.freezer;

import data.Product.Product;
import data.Product.ProductService;
import data.Product.ProductTyp;

import java.io.Serializable;
import java.util.*;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */
public class Tray implements Serializable {

    private static final long serialVersionUID = 7413749313438757709L;
    private  int trayID;
    private final Map<ProductTyp, TreeSet<Product>> products= new TreeMap<>();

    /**
     * @param numberOfTray from a freezer. Create trays for number of trays
     */
    public Tray(int numberOfTray){
        products.put(ProductTyp.VEGETABLES,new TreeSet<>());
        products.put(ProductTyp.PORK,new TreeSet<>());
        products.put(ProductTyp.BEEF,new TreeSet<>());
        products.put(ProductTyp.POULTRY,new TreeSet<>());
        products.put(ProductTyp.CALF,new TreeSet<>());
        products.put(ProductTyp.LAMB,new TreeSet<>());
        products.put(ProductTyp.FRUIT,new TreeSet<>());
        products.put(ProductTyp.ICE,new TreeSet<>());
        products.put(ProductTyp.SAUCES,new TreeSet<>());
        products.put(ProductTyp.MEALS,new TreeSet<>());
        products.put(ProductTyp.PIZZA,new TreeSet<>());
        products.put(ProductTyp.OTHER,new TreeSet<>());
        trayID=numberOfTray;
    }

    /**
     *
     * @return the id of the tray
     */
    public int getID() {
        return trayID;
    }


    @Override
    public boolean equals(Object o) {
    if(this==o)return true;
    if(!(o instanceof Product))return false;
    Tray tray= (Tray)o;
    if(trayID==tray.trayID)return true;
    return false;
    }
    @Override
    public int hashCode() {
        return this.trayID;
    }
}
