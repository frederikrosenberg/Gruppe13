package business.Logging;

import common.IPersistenceFacade;
import java.util.ArrayList;
import common.ILog;
import common.ILoggingFacade;
import common.LogType;
import java.util.List;

/**
 * The logging facade
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class LoggingFacade implements ILoggingFacade{
    /**
     * Contains the persistence instance
     */
    private IPersistenceFacade persistence;

    /**
     * Contains all of the logs
     */
    private ArrayList<Log> logs;
    
    /**
     * Constructs a logging facade
     * @param persistence The persistence instance
     */
    public LoggingFacade(IPersistenceFacade persistence) {
        this.persistence = persistence;
        logs = new ArrayList();
    }
    
     /**
     * Gets all logs from the given type
     * @param type The type of the logs to get
     * @return Allo logs form the given type
     */
    @Override
    public List<? extends ILog> getLogsOfType(LogType type) {
        List<Log> temp = new ArrayList();
        for (Log log : logs) {
            if(log.getLogType() == type) temp.add(log);
        }
        return temp;
    }

    /**
     * Gets all logs
     * @return All logs
     */
    @Override
    public List<? extends ILog> getAllLogs() {
        return logs;
    }

    /**
     * Creates a normal log
     * @param type The type of the log
     * @param userId The user id who caused the log
     */
    @Override
    public void createLog(LogType type, String userId) {
        Log log = new Log(type, userId);
        logs.add(log);
        // TODO Sent log to persistence
    }

    /**
     * Creates a attempt login log
     * @param type The type of the log
     * @param username The username who tried to login
     */
    @Override
    public void createLoginAttemptLog(LogType type, String username) {
        LoginAttemptLog log = new LoginAttemptLog(username, type);
        logs.add(log);
        // TODO sent log to persistence
    }

    /**
     * Creates a case log
     * @param type The type of the log
     * @param userId The user id who caused the log
     * @param caseId The case id of the case this log is about
     */
    @Override
    public void createCaseLog(LogType type, String userId, int caseId) {
        CaseLog log = new CaseLog(caseId, type, userId);
        logs.add(log);
        // TODO sent log to persistence
    }
}
