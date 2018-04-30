package business.security;

import business.common.ISecurityFacade;
import common.IUserManager;
import common.Role;

/**
 * The facade of the security Package
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class SecurityFacade implements ISecurityFacade {

    /**
     * An instance of the user manager, responsible for creating and storing the
     * registered users of the system.
     */
    private UserManager users;
    /**
     * An instance of the security manager, responsible for most of the security
     * logic.
     */
    private SecurityManager security;

    /**
     * A Constructor for the Security facade, which allows the injection of the
     * security manager and the user manager into each other.
     */
    public SecurityFacade() {
        users = new UserManager(security);
        security = new SecurityManager(users);
    }

    /**
     * A Constructor for the Security facade, which allows the injection of the
     * security manager and the user manager into each other. This constructor
     * uses an IUserManager to load users into the system.
     *
     * @param userManager
     */
    public SecurityFacade(IUserManager userManager) {
        users = new UserManager(security, userManager);
        security = new SecurityManager(users);
    }

    /**
     * Logs the current user into the system, if their username and password
     * matches that of a registered user.
     *
     * @param username the username of the user attempting to log in
     * @param password the password of the user attempting to log in
     * @return user id if the log in was successful, otherwise null
     */
    @Override
    public String logIn(String username, String password) {
        return security.logIn(username, password);
    }

    /**
     * Logs the current user out of the system.
     *
     * @return user id if the log out was successful, otherwise null
     */
    @Override
    public boolean logOut() {
        return security.logOut();
    }

    /**
     * Returns true if the current user has the given role, false otherwise.
     *
     * @param role The role the current user is being checked for.
     * @return true if the current user has the given role, false otherwise
     */
    @Override
    public boolean hasAccess(Role role) {
        return security.hasAccess(role);
    }

    /**
     * Return. the user manager containing the users.
     *
     * @return the user manager containing the users
     */
    public IUserManager getUserManager() {
        return users;
    }
}
