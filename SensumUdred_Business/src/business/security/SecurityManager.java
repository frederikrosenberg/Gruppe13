package business.security;

import common.IUser;
import common.IUserManager;
import common.Role;

/**
 * The class responsible for most security logic in the system.
 * @author Krongrah
 */
public class SecurityManager {

    /**
     * A reference to the user manager.
     */
    private UserManager userManager;
    /**
     * The current user of the system.
     */
    private IUser currentUser = null;
    /**
     * The hasher responsible for hashing passwords.
     */
    private Hasher hasher = new Hasher();

    /**
     * A constructor for the security manager, injecting a list of users to test
     * attempted log ins against.
     *
     * @param userManager the user manager of the system
     */
    public SecurityManager(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * This method evaluates if the username and password matches a registered
     * user
     *
     * @param username the username to be matched against the existing ones
     * @param password the password to be matched against the existing ones
     * @return true if the login was successful, otherwise false
     */
    public boolean logIn(String username, String password) {
        if (!hasher.isReady()) {
            System.err.println("Hasher not ready");
            return false;
        }
        String hashedPassword = hashPassword(password);
        for (IUser user : userManager.getUsers()) {
            if (user.getActive() && user.getUsername().equals(username)
                    && user.getPassword().equals(hashedPassword)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    /**
     * Logs the active user out
     *
     * @return true if the log out was successful
     */
    public boolean logOut() {
        currentUser = null;
        return true;
    }

    /**
     * Hashes the user's password
     *
     * @param password the password that needs to be hashed
     * @return the hashed password
     */
    String hashPassword(String password) {
        return hasher.hash(password);
    }

    /**
     * Returns true if the current user has the given role, false otherwise.
     *
     * @param role The role the current user is being checked for.
     * @return true if the current user has the given role, false otherwise
     */
    boolean hasAccess(Role role) {
        if (currentUser.getActive() && currentUser.getRole().equals(role)) {
            return true;
        }

        return false;
    }
}
