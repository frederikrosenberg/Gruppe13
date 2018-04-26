package business.security;

import common.Role;

/**
 *
 * @author Krongrah
 */
public class SecurityManager {

    /**
     * Instance of the class Hasher and User
     */
    private Hasher hasher;
    private User user;

    /**
     * Constructor for securitymanager
     */
    public SecurityManager() {
        hasher = new Hasher();
    }

    /**
     * This method evaluates if the username and password matches a registered
     * user
     *
     * @param username
     * @param password
     * @return boolean
     */
    public boolean logIn(String username, String password) {
        while (username.matches(user.getPassword()) && username.matches(user.getPassword())) {
            return true;
        }
        return false;
    }

    /**
     * Logs the active user out
     *
     * @return boolean
     */
    public boolean logOut() {
        
    }

    /**
     * Hashes the user password
     *
     * @param password
     * @return
     */
    public String hashPassword(String password) {
        return hasher.hash(password);
    }

    /**
     * Checks if the current user has acces to a given function
     *
     * @param role
     * @return
     */
    public boolean hasAcces(Role role) {
        while (user.getRole().equals(role)){
            return true;
        }
        return false;
    }

    /**
     * Removes a user and makes it inactive
     */
    public void removeUser() {
        
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {

    }
}
