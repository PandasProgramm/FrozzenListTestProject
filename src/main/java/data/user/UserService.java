package data.user;

import data.service.ServiceI;
import data.service.moddle.objects.UserMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 * User service for adding or removing a user
 * save settings after every operation
 */
public class UserService extends UserMapper implements ServiceI<User> {

    private Set<User> users= new TreeSet<>();

    public UserService() throws SQLException {
    }

    /**
     *
     * @param user add user tu user list and save them
     */
    @Override
    public void add(User user) {
    users.add(user);
    try{
        save(user);
    }catch (SQLException sqlException){
        //TODO: message
    }
    }

    /**
     *
     * @param user remove
     */
    @Override
    public void remove(User user) {
        users.remove(user);
        try{
        delete(user);
        }catch (SQLException sqlException){
            //TODO:message
        }
    }

    /**
     *
     * @param id of the user TODO: iD
     * @return the user id TODO: gui
     */
    @Override
    public User getOne(int id) {

        try {
           User user= findOneByID(id);
            return user;
        } catch (SQLException sqlException) {
            //TODO:message
        }return null; //TODO: OPTIONAL USIGNG
    }
    /**
     * @return get all user TODO: gui
     */
    @Override
    public TreeSet<User> getAll() {
     TreeSet<User>userTreeSet= new TreeSet<>();
        try{
            List<User> userList=findAll();
            userList.stream().collect(Collectors.toSet()).forEach(user->userTreeSet.add(user));

        }catch (SQLException sqlException){
            //TODO: message
        }return userTreeSet;

    }

}
