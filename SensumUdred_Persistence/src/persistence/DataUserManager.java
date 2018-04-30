package persistence;

import common.IUser;
import common.IUserManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Data class for user manager
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class DataUserManager implements IUserManager, Serializable {

    /**
     * The users in the system
     */
    private List<DataUser> users;
    
    /**
     * Constructor for the data user manager
     * @param userManager the user manager
     */
    public DataUserManager(IUserManager userManager) {  
        users = new ArrayList<>();
        for (IUser user : userManager.getUsers()) {
            users.add(new DataUser(user));
        }
    }
    
    /**
     * Gets all the user in a department
     * @return the users in the department
     */
    @Override
    public List<? extends IUser> getUsers() {
        return users;
    }
    
}
