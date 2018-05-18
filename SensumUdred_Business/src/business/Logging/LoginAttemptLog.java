package business.Logging;

import common.ILoginAttemptLog;
import common.LogType;

/**
 * The login attempt log
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class LoginAttemptLog extends Log implements ILoginAttemptLog {

     /**
     * Contains the username of the attempted login
     */
    private String username;
    
    /**
     * Constructs a login attempt log
     * @param username The username of the user who tried to login
     * @param logType The log type
     */
    public LoginAttemptLog(String username, LogType logType) {
        super(logType, null);
        this.username = username;
    }

    /**
     * Gets the username of the attempted login
     * @return The username of the attempted login
     */
    @Override
    public String getUsername() {
        return username;
    }
    
}
