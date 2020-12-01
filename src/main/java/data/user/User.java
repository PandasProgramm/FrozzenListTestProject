package data.user;

import data.freezer.Tray;
import model.AbstractEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 * A user can have a freezer or more freezers
 * every user has a name and a password for login
 * the count counts the number of userObjects e.g number of users.
 * Every user can set freezers and can have single trays of a freezer
 */
public class User extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 482583513956011763L;

    private String userName;
    private String password;

    private int userId;
    private int freezerID;
    private List<Tray> trayList= new ArrayList<>();

    private static int count;
    /**
     *
     * @param name for login
     * @param password for login
     */
    public User(String name, String password) {
        this.userName = name;
        this.password = password;
        count++;
        userId=count;
    }
    public User(String name,int id){
        this.userName = name;
        this.userId=id;
        setId(userId);
    }

    /**
     * set number of user plus one => first user has the id 1
     */
    public User(){}


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * entity of user
     * @return user name
     */
    public String getName() {
        return userName;
    }

    /**
     *entity is possible for changing
     *@param name set user name
     */
    public void setName(String name) {
        this.userName = name;
    }



    public void setFreezerID(int freezerID) {
        this.freezerID = freezerID;
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
        if(this.userId==user.userId){
            return true;
        }return false;
    }
    @Override
    public int hashCode() {
     return userId;
    }
    @Override
    public String toString() {
        return userName+"#";
    }
}
