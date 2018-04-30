package business.security;

import common.IUser;
import common.IUserManager;
import common.Role;
import static common.Role.CASEWORKER;
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
     *
     * @param security
     */
    UserManager(SecurityManager security) {
        this.security = security;
        //Adding dummy data.
        addUser("name", "username", "password", CASEWORKER);
    }

    /**
     * A constructor setting the security manager reference and taking an IUser
     * to get user data from.
     *
     * @param security a reference to the security manager.
     * @param IUsers an IUserManager containing IUsers for all the users
     */
    UserManager(SecurityManager security, IUserManager userManager) {
        this.security = security;
        for (IUser user : userManager.getUsers()) {
            users.add(new User(user));
        }
    }

    /**
     * Returns an unmodifiable list of users of the system.
     *
     * @return an unmodifiable list of users of the system
     */
    @Override
    public List<? extends IUser> getUsers() {
        return Collections.unmodifiableList(users);
    }

    /**
     * Adds a new user to the system.
     *
     * @param name the name of the user
     * @param username the username of the user
     * @param password the password of the user
     * @param role the role of the user
     */
    public void addUser(String name, String username, String password, Role role) {
        users.add(new User(name, username, security.hashPassword(password), role, generateId()));
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
