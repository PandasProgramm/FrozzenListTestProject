package data.freezer;

import data.service.model.AbstractEntity;

import java.io.Serializable;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */
public class Freezer extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -7221585265587747653L;
    private String name;
    private  int freezerId;
    private Tray []trays;

    /**
     * name for individual personalize of the freezer
     * @param id give the id of a freezer in dependency of the user
     * @param numberOfTray of a freezer
     */
    public Freezer(int id,String name,int numberOfTray) {
        this.name= name;
        this.freezerId = id;
        this.trays = new Tray[numberOfTray];
        for(int i=0;i<trays.length;i++){
            trays[i]=new Tray((i+1));
        }
    }
    /**
     * this constructor is for the database
     */
    public Freezer(){}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     *
     * @return name of the freezer
     */
    public String getName() {
        return name;
    }
    /**
     *
     * @param name set to the freezer by GUI
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @param freezerId set to the user
     */
    public void setFreezerId(int freezerId) {
        this.freezerId = freezerId;
    }

    /**
     *
     * @return all trays of the freezer objects
     */
    public Tray[] getTrays() {
        return trays;
    }

    /**
     *
     * @param trays add the entity for freezer: a freezer has n numbers of trays where is fix after adding a freezer
     */
    public void setTrays(Tray[] trays) {
        this.trays = trays;
    }

}
