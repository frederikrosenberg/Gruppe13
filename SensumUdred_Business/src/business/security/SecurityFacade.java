/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.security;

import business.common.ISecurityFacade;
import common.Role;

/**
 * The facade of the security Package
 *
 * @author Krongrah
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
     * Logs the current user into the system, if their username and password
     * matches that of a registered user.
     *
     * @param username the username of the user attempting to log in
     * @param password the password of the user attempting to log in
     * @return true if the log in was successful, otherwise false
     */
    @Override
    public boolean logIn(String username, String password) {
        return security.logIn(username, password);
    }

    /**
     * Logs the current user out of the system.
     *
     * @return true if the log out was successful, otherwise false
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

}
