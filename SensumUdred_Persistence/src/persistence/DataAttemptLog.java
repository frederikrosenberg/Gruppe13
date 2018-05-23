package persistence;

import common.ILoginAttemptLog;
import common.LogType;
import java.util.Date;

/**
 * Data class for attempt log
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class DataAttemptLog extends DataLog implements ILoginAttemptLog {
    
    /**
     * The username that was used in the login try
     */
    private String username;
    
    /**
     * Constructor for attempt log
     * @param type the type of log
     * @param date the date of the log
     * @param username the user used trying to login
     */
    public DataAttemptLog(LogType type, Date date, String username) {
        super(type, date, null);
        this.username = username;
    }

    /**
     * Get the username that was used when trying to login
     * @return the username
     */
    @Override
    public String getUsername() {
        return username;
    }
    
}
