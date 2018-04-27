/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.common;

/**
 * The interface for the security facade.
 *
 * @author mikkellarsen
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
    public boolean logIn(String username, String password);

    /**
     * Logs the user out of the system.
     *
     * @return true if the log out was successful, otherwise false.
     */

    public boolean logOut();
}
