package data.freezer;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */
public class Freezer implements Serializable {

    private static final long serialVersionUID = -7221585265587747653L;
    private final int id;
        Tray []trays;

    /**
     *
     * @param id give the id of a freezer in dependency of the user
     * @param numberOfTray of a freezer
     */
    public Freezer(int id,int numberOfTray) {
        this.id = id;
        this.trays = new Tray[numberOfTray];
        for(int i=0;i<trays.length;i++){
            trays[i]=new Tray((i+1));
        }
    }



}
