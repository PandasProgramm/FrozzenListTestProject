package data.freezer;

import data.service.General_I;

import java.io.*;
import java.util.HashSet;

/**
 * @author  Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 *
 * for creating and saving a freezer
 */
public class FreezerService implements General_I<Freezer> {

    private HashSet<Freezer>freezers= new HashSet<>();
    private static final String DATA_FILE_FREEZER="freezer.db";

    /**
     *
     * @param freezer: add a freezer from a User
     * @link Freezer
     */
    @Override
    public void add(Freezer freezer) {
    freezers.add(freezer);
    saveToFile();
    }

    /**
     *
     * @param freezer: remove a freezer from a user
     * @link Freezer
     */
    @Override
    public void remove(Freezer freezer) {
        freezers.remove(freezer);
        saveToFile();
    }

    /**
     *
     * @return all freezers from a user
     */
    public HashSet<Freezer> getFreezers() {
        return  new HashSet<Freezer>();
    }

    /**
     * to save the freezer data
     */
    @Override
    public void saveToFile() {
        try(ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream(DATA_FILE_FREEZER))){
            objectOutputStream.writeObject(freezers);
        }catch (IOException exception){
            //TODO:message
        }
    }
    /**
     * to load the freezer data
     */
    @Override
    public void readFromFile() {
        try(ObjectInputStream objectInputStream= new ObjectInputStream(new FileInputStream(DATA_FILE_FREEZER))){
                objectInputStream.readObject();
        }catch (IOException|ClassNotFoundException exception){
            freezers= new HashSet<Freezer>();
        }
    }

}
