package business.Logging;

import common.ILog;
import common.LogType;
import java.util.Date;

/**
 * The generel log
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class Log implements ILog {

    /**
     * Constructs a log
     * @param logType The log type
     * @param userId The user id
     */
    public Log(LogType logType, String userId) {
        this.logType = logType;
        this.date = new Date();
        this.userId = userId;
    }

    /**
     * The logs type
     */
    private LogType logType;
    
    /**
     * The date of the log
     */
    private Date date;
    
    /**
     * The user id that caused the log
     */
    private String userId;
    
    /**
     * Gets the log type
     * @return The log type
     */
    @Override
    public LogType getLogType() {
        return logType;
    }

    /**
     * Gets the date of the log
     * @return The date of the log
     */
    @Override
    public Date getDate() {
        return date;
    }

    /**
     * Gets the user id
     * @return The user id
     */
    @Override
    public String getUserId() {
        return userId;
    }
    
}
