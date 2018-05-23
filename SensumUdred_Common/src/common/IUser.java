package common;

/**
 * The interface of the user.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface IUser {

    /**
     * Getter for the role the user has
     *
     * @return the user role
     */
    Role getRole();

    /**
     * Getter for the users username
     *
     * @return the username of the user
     */
    String getUsername();

    /**
     * Getter for the users id
     *
     * @return the user id
     */
    String getUserId();

    /**
     * Getter for the users hashed password
     *
     * @return the password
     */
    String getPassword();

    /**
     * Getter for the name of the user
     *
     * @return name of user
     */
    String getName();

    /**
     * Getter for if the user is active or not. If active the user has not been
     * deleted
     *
     * @return if the user is active
     */
    boolean getActive();
}
