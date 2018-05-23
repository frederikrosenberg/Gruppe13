package business.security;

import business.BusinessFacade;
import business.Persistence;
import common.IUser;
import common.IUserManager;
import common.Role;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * The class that creates and stores all the users of the system
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class UserManager implements IUserManager {

    /**
     * The a list containing all the users of the system.
     */
    private List<User> users = new ArrayList();
    /**
     * A reference to the security manager.
     */
    private SecurityManager security;

    /**
     * A constructor setting the security manager reference.
     */
    public UserManager() {
        //Adding dummy data.
        
    }

    /**
     * A constructor setting the security manager reference and taking an IUser
     * to get user data from.
     * 
     * @param userManager an IUserManager containing IUsers for all the users
     */
    public UserManager(IUserManager userManager) {
        for (IUser user : userManager.getUsers()) {
            users.add(new User(user));
        }
    }
    
    /**
     * Inject the security manager
     * @param securityManager the manager
     */
    public void injectSecurityManager(SecurityManager securityManager) {
        security = securityManager;
    }

    /**
     * Returns an unmodifiable list of users of the system.
     *
     * @return an unmodifiable list of users of the system
     */
    @Override
    public List<? extends IUser> getUsers() {
        for (IUser user : Persistence.getInstance().getPersistenceFacade().getUsers()) {
            users.add(new User(user));
        }
        return Collections.unmodifiableList(users);
    }

    /**
     * Adds a new user to the system and returns its user id
     *
     * @param name the name of the user
     * @param username the username of the user
     * @param password the password of the user
     * @param role the role of the user
     * @return the user id of the new user
     */
    public String addUser(String name, String username, String password, Role role) {
        String id = generateId();
        IUser user = new User(name, username, security.hashPassword(password), role, id);
        Persistence.getInstance().getPersistenceFacade().addUser(user);
        users.add((User) user);
        return id;
    }

    /**
     * Generates a unique 36 digit id.
     *
     * @return a unique 36 digit id
     */
    private String generateId() {
        String userId = "";
        boolean duplicates = true;

        while (duplicates) {
            duplicates = false;
            userId = UUID.randomUUID().toString();
            for (User user : users) {
                if (user.getUserId().equals(userId)) {
                    duplicates = true;
                    break;
                }
            }
        }
        return userId;

    }

}
