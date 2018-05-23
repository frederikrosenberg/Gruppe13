package persistence;

import common.ILog;
import common.LogType;
import java.util.Date;

/**
 * Data object for log
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class DataLog implements ILog {
    
    /**
     * The log type
     */
    private LogType type;
    
    /**
     * The date of the log entry
     */
    private Date date;
    
    /**
     * Which user created the log
     */
    private String userId;
    
    /**
     * Constructor for the log
     * @param type the type of log
     * @param date the date the log was created
     * @param userId the user who created the log
     */
    public DataLog(LogType type, Date date, String userId) {
        this.type = type;
        this.date = date;
        this.userId = userId;
    }

    /**
     * Gets the log type
     * @return the log type
     */
    @Override
    public LogType getLogType() {
        return type;
    }

    /**
     * Gets the date of the log
     * @return the date
     */
    @Override
    public Date getDate() {
        return date;
    }

    /**
     * Get the user who created the log
     * @return the user id
     */
    @Override
    public String getUserId() {
        return userId;
    }
    
}
