package business.security;

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
 * @author Krongrah
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
        String userId="";
        boolean duplicates=true;
                
        while (duplicates) {
            duplicates=false;
            userId = UUID.randomUUID().toString();
            for (User user : users) {
                if (user.getUserId().equals(userId)) {
                    duplicates=true;
                }
            }
        }
        return userId;

    }

}
