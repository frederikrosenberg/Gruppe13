package persistence;

import common.IUser;
import common.Role;
import java.io.Serializable;

/**
 * Data class for user
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class DataUser implements IUser, Serializable {
    
    /**
     * The role the user has
     */
    private Role role;
    
    /**
     * The user's username
     */
    private String username;
    
    /**
     * The user id the user has
     */
    private String userId;
    
    /**
     * The user's hashed password
     */
    private String password;
    
    /**
     * The name of the user
     */
    private String name;
    
    /**
     * Weather the user is active, meaning that it has not been deleted
     */
    private boolean active;
    
    /**
     * Constructor for the data user
     * @param user the given user
     */
    public DataUser(IUser user) {
        role = user.getRole();
        username = user.getUsername();
        userId = user.getUserId();
        password = user.getPassword();
        name = user.getName();
        active = user.getActive();
    }

    /**
     * Constructor for data user
     * @param role the role the user has
     * @param username the username of the user
     * @param userId the id of the user
     * @param password the password
     * @param name the name of the user
     * @param active if the user is active or not. If active is false the user counts as deleted.
     */
    public DataUser(Role role, String username, String userId, String password, String name, boolean active) {
        this.role = role;
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.active = active;
    }
    

    /**
     * Getter for the role the user has
     * @return the user role
     */
    @Override
    public Role getRole() {
        return role;
    }

    /**
     * Getter for the users username
     * @return the username of the user
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Getter for the users id
     * @return the user id
     */
    @Override
    public String getUserId() {
        return userId;
    }

    /**
     * Getter for the users hashed password
     * @return 
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Getter for the name of the user
     * @return name of user
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter for if the user is active or not. If active the user has not been deleted
     * @return if the user is active
     */
    @Override
    public boolean getActive() {
        return active;
    }
    
}
