package common;

/**
 * The interface for case log
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface ILoginAttemptLog extends ILog {
    /**
     * Gets the username of the attempted login
     * @return The username of the attempted login
     */
    String getUsername();
}
