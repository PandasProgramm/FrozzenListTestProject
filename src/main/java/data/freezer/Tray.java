package data.freezer;

import data.Product.Product;
import data.Product.ProductTyp;
import model.AbstractEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */
public class Tray extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 7413749313438757709L;
    private  int trayID;
    private final List<Product> products= new ArrayList<>();

    /**
     * @param numberOfTray from a freezer. Create trays for number of trays
     */
    public Tray(int numberOfTray){
        trayID=numberOfTray;
      
    }
    public Tray(){}

    /**
     * get sorting list by freezing date for the gui
     * @return a sorted list by product type
     */
    public String productSortByProductType(){
        Map<ProductTyp, List<Product>>productTypListMap=products.stream().collect(Collectors.groupingBy(Product::getProductTyp));
        return convertWithIteration(productTypListMap);
    }
    /**
     * get sorting list by freezing date for the gui
     * @return a sorted list by freezing date
     */
    public String productSortByFreezingDate(){
        Map<LocalDate,List<Product>>freezingDateMap= products.stream().collect(Collectors.groupingBy(Product::getFreezingDate));
        return convertWithIteration(freezingDateMap);
    }
    /**
     * get sorting list by mark in the gui
     * @return a sorted list by product mark for the gui
     */
    public String productSortByMark(){
        List<Product>productListSort= products.stream()
                .sorted((productOne,productTwo)->productOne.getMark().compareTo(productTwo.getMark()))
                .collect(Collectors.toList());
        return productListSort.toString();
    }
    /**
     *
     * @param map sorted
     * @param <T> product entity by sorted
     * @return a converted string of the map
     * @link producSortByMark, productSortByFreezingDate, productSortByProductType
     */
    private  <T>String convertWithIteration(Map<T,?>map) {
        String mapASString = map.keySet().stream().map(key->key+"#"+map.get(key)).collect(Collectors.joining(","));
        return mapASString;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public void setTrayID(int trayID) {
        this.trayID = trayID;
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
