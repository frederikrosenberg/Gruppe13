package persistence;

import common.IUser;
import common.IUserManager;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fsr19
 */
public class DataUserManager implements IUserManager, Serializable {

    /**
     * Gets all the user in a department
     * @return the users in the department
     */
    @Override
    public List<IUser> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
