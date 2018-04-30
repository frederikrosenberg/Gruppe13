package common;

import java.util.List;

/**
 * The interface of the user manager.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface IUserManager {

    /**
     * Gets all the user in a department
     *
     * @return the users in the department
     */
    List<? extends IUser> getUsers();
}
