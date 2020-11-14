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

    private TreeSet<User>users= new TreeSet<>();

    /**
     *
     * @param user add user tu user list and save them
     */
    @Override
    public void add(User user) {
    users.add(user);
        //TODO: SAVE
    }

    /**
     *
     * @param user remove
     */
    @Override
    public void remove(User user) {
        users.remove(user);
        //TODO: SAVE
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


    /**
     * load the data
     */

}
