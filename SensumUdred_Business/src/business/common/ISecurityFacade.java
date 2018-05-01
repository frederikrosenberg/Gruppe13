package business.common;

import common.IUserManager;
import common.Role;

/**
 * The interface for the security facade.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface ISecurityFacade {

    /**
     * logs the user into the system if the username and password entered
     * matches that of an existing user.
     *
     * @param username the username of the user attempting to log in
     * @param password the password of the user attempting to log in
     * @return true if the username and password both matches a registered user,
     * false otherwise
     */
     String logIn(String username, String password);

    /**
     * Logs the user out of the system.
     *
     * @return true if the log out was successful, otherwise false.
     */
     boolean logOut();

    /**
     * Returns true if the current user has the given role, false otherwise.
     *
     * @param role The role the current user is being checked for.
     * @return true if the current user has the given role, false otherwise
     */
    boolean hasAccess(Role role);

    /**
     * Return. the user manager containing the users.
     *
     * @return the user manager containing the users
     */
    IUserManager getUserManager();

    /**
     * Adds a new user to the system and returns its user id
     *
     * @param name the name of the user
     * @param username the username of the user
     * @param password the password of the user
     * @param role the role of the user
     * @return the user id of the new user
     */
    String addUser(String name, String username, String password, Role role);

}
