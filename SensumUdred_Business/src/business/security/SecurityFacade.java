/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.security;

import business.common.ISecurityFacade;

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
    private UserManager users = new UserManager();
    /**
     * An instance of the security manager, responsible for most of the security
     * logic.
     */
    private SecurityManager security = new SecurityManager(users.getUsers());

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

}
