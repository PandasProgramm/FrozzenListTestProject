package data.user;

import data.service.ServiceI;
import java.io.*;
import java.util.TreeSet;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 * User service for adding or removing a user
 * save settings after every operation
 */
public class UserService implements ServiceI<User> {

    private static final String DATA_FILE="data.db";
    private TreeSet<User>users= new TreeSet<>();

    /**
     *
     * @param user add user tu user list and save them
     */
    @Override
    public void add(User user) {
    users.add(user);
    saveToFile();
    }

    /**
     *
     * @param user remove
     */
    @Override
    public void remove(User user) {
        users.remove(user);
        saveToFile();
    }

    /**
     *
     * @param id of the user TODO: iD
     * @return the user id TODO: gui
     */
    @Override
    public User getOne(int id) {
        return null;
    }
    /**
     * @return get all user TODO: gui
     */
    @Override
    public TreeSet<User> getAll() {
        return null;
    }

    /**
     * save the changes
     */
    @Override
    public void saveToFile() {
        try(ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream(DATA_FILE))){
            objectOutputStream.writeObject(users);
        }catch (IOException ex){
            //TODO: message
        }
    }

    /**
     * load the data
     */
    @Override
    public void readFromFile() {

        try(ObjectInputStream objectInputStream= new ObjectInputStream(new FileInputStream(DATA_FILE))){
            users = (TreeSet<User>) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException ex){
            //TODO: message
            users=new TreeSet<User>();
        }
    }
}
