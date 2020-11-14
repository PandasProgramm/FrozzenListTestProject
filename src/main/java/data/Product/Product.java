package data.Product;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */
public class Product implements Serializable {

    /**
     * every product have a mark,a product type a name, and a amount. For every product with the same entity of mark,
     * product type and the amount give a number of product: the pieces of product
     * the product will be store for a period. When the period is over, the user gets a message from the GUI
     */

    private static final long serialVersionUID = -5220159028566792859L;
    private int productId;
    private final ProductTyp productTyp;
    private final String mark;
    private final String name;
    private int pieces;
    private final double amount;

    private LocalDate freezingDate;
    private LocalDate expirationDate;
    private LocalTime inputTime;

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
        this.name = name;
        this.mark = mark;
        this.amount= amount;

        freezingDate= LocalDate.now();
        inputTime= LocalTime.now();
        localDateTime= LocalDateTime.of(freezingDate,inputTime);
        Period period= productTyp.getStorageLiveTimeOfProduct();
        expirationDate= freezingDate.plus(period);
    }
    public Product(String mark,ProductTyp productTyp, String name,double amount,int id){
        this(mark,productTyp,name,amount);
        this.productId=id;
    }
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
        return name;
    }

    /**
     *
     * @return the storage date
     */
    public LocalDate getFreezingDate(){
        return freezingDate;
    }

    /**
     *
     * @return the expiration date for system warnings
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    /**
     *
     * @param pieces in dependent of product keys for the number of the same product
     */
    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    /**
     *
     * @return the pieces of the same product
     */
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
              if(this.name==product.name){
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
                ", name='" + name + '\'' +
                ", pieces=" + pieces +
                ", amount=" + amount +
                '}';
    }
}
