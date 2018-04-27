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
     * @param password the hashed password of the user
     * @param role the role of the user
     */
    public void addUser(String name, String username, String password, Role role) {
        users.add(new User(name, username, password, role, generateId()));

    }

    /**
     * Generates a unique 36 digit id.
     *
     * @return a unique 36 digit id
     */
    private String generateId() {
        String userId;
        loop:
        while (true) {
            userId = UUID.randomUUID().toString();
            for (User user : users) {
                if (user.getUserId().equals(userId)) {
                    continue loop;
                }
            }
            break;
        }
        return userId;
    }

}
