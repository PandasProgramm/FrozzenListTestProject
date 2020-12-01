package data.service.moddle.objects;

import data.purchasing.list.PurchasingList;
import model.AbstractMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Miguel Gutierrez on 13.11.2020
 * TODO : WORKING ON THE DATABASESTRUCTURE
 */
public class PurchasingListMapper extends AbstractMapper<PurchasingList> {

    protected PurchasingListMapper() {
        super("purchasingLists");
    }


    @Override
    public PurchasingList convert(ResultSet resultSet) throws SQLException {
        return null; //TODO: yo database :*
    }

    @Override
    public boolean createTable() throws SQLException {
        return false; //TODO: creating purchasing list ;)
    }

}
