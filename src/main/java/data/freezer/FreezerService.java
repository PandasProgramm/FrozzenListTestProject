package data.freezer;

import data.service.General_I;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author  Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 *
 * for creating and saving a freezer
 */
public class FreezerService implements General_I<Freezer> {

    private Set<Freezer> freezers= new TreeSet<>();


    /**
     *
     * @param freezer: add a freezer from a User
     * @link Freezer
     */
    @Override
    public void add(Freezer freezer) {
    freezers.add(freezer);
   //TODO: SAVE
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
        freezers.remove(freezer);
        //TODO: SAVE

    }

    /**
     *
     * @return all freezers from a user
     */
    public Set<Freezer> getFreezers() {
        return  new TreeSet<>();
    }

    /**
     * to save the freezer data
     */


}
