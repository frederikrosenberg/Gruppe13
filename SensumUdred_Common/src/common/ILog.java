package common;

import java.util.Date;

/**
 * The interface for log
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface ILog {
    /**
     * Gets the log type of the log
     * @return The log type of the log
     */
    LogType getLogType();
    
    /**
     * Gets the date of the log
     * @return The date of the log
     */
    Date getDate();
    
    /**
     * Gets the user id
     * @return The user id
     */
    String getUserId();
}
