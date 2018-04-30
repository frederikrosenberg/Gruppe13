/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.security;

import common.IUser;
import common.Role;

/**
 * A registered user of the system
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class User implements IUser {

    /**
     * The name of the user
     */
    private String name;
    /**
     * The id of the user
     */
    private String userId;
    /**
     * The username of the user
     */
    private String username;
    /**
     * The hashed password of the user
     */
    private String password;
    /**
     * The role of the user; either case worker or citizen
     */
    private Role role;

    /**
     * True if the the user has access to the system. False of the user has lost
     * permission to the system.
     */
    private boolean active = true;

    /**
     * The constructor of the user class
     *
     * @param name the name of the user
     * @param username the username of the user
     * @param password the hashed password of the user
     * @param role the role of the user; either case worker or citizen
     * @param userId The id of the user
     */
    public User(String name, String username, String password, Role role, String userId) {
        this.name = name;
        this.username = username;
        this.role = role;
        this.password = password;
        this.userId = userId;
    }

    /**
     * Returns the role of the user.
     *
     * @return the role of the user
     */
    @Override
    public Role getRole() {
        return role;
    }

    /**
     * sets the user to deactivated, removing their access to the system
     */
    public void deactivateUser() {
        active = false;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username of the user
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the id of the user,
     *
     * @return the id of the user
     */
    @Override
    public String getUserId() {
        return userId;
    }

    /**
     * Returns the hashed password of the user.
     *
     * @return the hashed password of the user
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns true of the user is active, and thus has access to the system,
     * else returns false.
     *
     * @return true of the user is active, and thus has access to the system,
     * else returns false
     */
    @Override
    public boolean getActive() {
        return active;
    }

}
