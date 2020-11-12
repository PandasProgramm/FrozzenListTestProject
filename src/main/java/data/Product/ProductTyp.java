package data.Product;

import java.time.Period;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */
public enum ProductTyp  {
    /**
     * a value for every product typ. Every type has a period of durability
     * The value has a standard period of 4 weeks
     * every user can change the period for every product type
     */

    VEGETABLES(),BEEF(),PORK(),POULTRY(),CALF(),LAMB(),FRUIT(),ICE(),SAUCES(),MEALS(),OTHER(),PIZZA();

    /**
     *
     * @param period to set the period for storage live time
     */
    public void setStorageLiveTime(Period period){
        this.storageLiveTimeOfProduct = period;
    }
    public Period getStorageLiveTimeOfProduct(){
        return this.storageLiveTimeOfProduct;
    }


    private Period storageLiveTimeOfProduct;

    /**
     *
     * @param period set period of the value from user
     */

    private ProductTyp(Period period){
        this.storageLiveTimeOfProduct= period;
    }
    private ProductTyp(){
        //TODO: message for standard period
        storageLiveTimeOfProduct=Period.ofWeeks(4);
    }
}
