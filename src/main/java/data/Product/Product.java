
/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */

package data.Product;

import data.service.model.AbstractEntity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.function.Supplier;


public class Product extends AbstractEntity implements Comparable<Product>,Serializable {

    /**
     * every product have a mark,a product type a name, and a amount. For every product with the same entity of mark,
     * product type and the amount give a number of product: the pieces of product
     * the product will be store for a period. When the period is over, the user gets a message from the GUI
     */

    private static final long serialVersionUID = -5220159028566792859L;
    private int productId;
    private  ProductTyp productTyp;
    private  String mark;
    private  String productName;
    private int pieces;
    private double amount;

    private Supplier<LocalDate> freezingDate;
    private Supplier<LocalDate> expirationDate;
    private Supplier<LocalTime> inputTime;

    private LocalDateTime localDateTime;

    /**
     *
     * @param mark of the product. Key entity
     * @param productTyp of the product. Key entity
     * @param name of the product.Key entity
     * @param amount of the product. Key entity
     */
    public Product(String mark,ProductTyp productTyp, String name,double amount) {

        this.productTyp = productTyp;
        this.productName = name;
        this.mark = mark;
        this.amount= amount;

        freezingDate= LocalDate::now;
        inputTime= LocalTime::now;
        localDateTime=LocalDateTime.of(freezingDate.get(),inputTime.get());
        Period period= productTyp.getStorageLiveTimeOfProduct();
        expirationDate= ()->freezingDate.get().plus(period);
    }
    public Product(String mark,ProductTyp productTyp, String name,double amount,int id){
        this(mark,productTyp,name,amount);
        this.productId=id;
    }
    public Product(){ }

    /**
     *
     * @return the product type of the single product
     */
    public ProductTyp getProductTyp() {
        return productTyp;
    }

    /**
     *
     * @return the name of the single product
     */
    public String getName() {
        return productName;
    }

    /**
     *
     * @return the storage date
     */
    public LocalDate getFreezingDate(){
        return freezingDate.get();
    }

    /**
     *
     * @return the expiration date for system warnings
     */
    public LocalDate getExpirationDate() {
        return expirationDate.get();
    }

    @Override
    public int compareTo(Product o) {
        return productName.compareTo(o.productName);
    }

    /**
     * @param pieces in dependent of product keys for the number of the same product
     */
    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    /**
     *
     * @return
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductTyp(ProductTyp productTyp) {
        this.productTyp = productTyp;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFreezingDate(Supplier<LocalDate> freezingDate) {
        this.freezingDate = freezingDate;
    }

    public void setExpirationDate(Supplier<LocalDate> expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalTime getInputTime() {
        return inputTime.get();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    /**
     *
     * @return the pieces of the same product
     */
    //TODO: consistent
    public int getPieces(){
        return pieces;
    }
    @Override
    public boolean equals(Object object){
        if(this==object)return true;
        if(!(object instanceof Product))return  false;
        Product product= (Product)object;
        if(this.mark== product.mark){
          if(this.productTyp==product.productTyp)
          {
              if(this.productName==product.productName){
                  if(this.amount==product.amount){
                      pieces++;
                      return true;
                  }
              }
          }
        }return false;
    }
    @Override
    public int hashCode() {
        return mark.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTyp=" + productTyp +
                ", mark='" + mark + '\'' +
                ", name='" + productName + '\'' +
                ", pieces=" + pieces +
                ", amount=" + amount +
                '}';
    }
}
