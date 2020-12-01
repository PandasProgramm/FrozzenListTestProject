package data.freezer;

import data.service.General_I;
import data.service.moddle.objects.FreezerMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author  Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 *
 * for creating and saving a freezer
 */
public class FreezerService implements General_I<Freezer> {

    private Set<Freezer> freezers= new TreeSet<>();
    private FreezerMapper freezerMapper= new FreezerMapper();


    /**
     * @param freezer: add a freezer from a User
     * @link Freezer
     */
    @Override
    public void add(Freezer freezer) {
     try{

         freezerMapper.save(freezer);
     }catch (SQLException sqlException){
         //TODO: message to fx
     }
    }
    public void setFreezers(Set<Freezer> freezers) {
        this.freezers = freezers;
    }
    /**
     *
     * @param freezer: remove a freezer from a user
     * @link Freezer
     */
    @Override
    public void remove(Freezer freezer) {
        try {
            freezerMapper.delete(freezer);
        }catch (SQLException sqlException){
            //TODO: message to fx
        }
    }
    /**
     *
     * @return all freezers from a user
     */
    public Set<Freezer> getFreezers() {
        Set<Freezer>freezers= new TreeSet<>();
        List<Freezer> freezerList;
        try {
           freezerList=freezerMapper.findAll();
           freezers=freezerList.stream().collect(Collectors.toSet());
        }catch (SQLException sqlException){
            //TODO: message to fx
        }
        return  freezers;
    }
}
