package data.user;

import data.freezer.Freezer;
import data.freezer.FreezerService;

import java.io.Serializable;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 * A user can have a freezer or more freezers
 * every user has a name and a password for login
 * the count counts the number of userObjects e.g number of users.
 * Every user can set freezers and can have single trays of a freezer
 */
public class User implements Serializable {

    private static final long serialVersionUID = 482583513956011763L;
    private String name;
    private String password;
    private static int count;
    private final int id;
    private FreezerService freezers;
    private int trayID;

    /**
     *
     * @param name for login
     * @param password for login
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        id=count+1;
        count++;
    }

    /**
     * set number of user plus one
     */
    public User(){this.id =count+1;}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     *
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name set user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return password of the user for login
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password set password of the user for changing
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object object){
        if(this==object)return true;
        if(!(object instanceof User))return false;

        User user= (User)object;
        if(this.id==user.id){
            return true;
        }return false;
    }

    @Override
    public int hashCode() {
     return id;
    }

    @Override
    public String toString() {
        return "name:";
    }
}
