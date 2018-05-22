package business.Logging;

import business.Persistence;
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
     * Contains all of the logs
     */
    private ArrayList<Log> logs;
    
    /**
     * Constructs a logging facade
     * @param persistence The persistence instance
     */
    public LoggingFacade() {
        logs = new ArrayList();
    }
    
     /**
     * Gets all logs from the given type
     * @param type The type of the logs to get
     * @return All logs from the given type
     */
    @Override
    public List<? extends ILog> getLogsOfType(LogType type) {
        /*List<Log> temp = new ArrayList();
        for (Log log : logs) {
            if(log.getLogType() == type) temp.add(log);
        }*/
        return Persistence.getInstance().getPersistenceFacade().getLogsOfType(type);
    }

    /**
     * Gets all logs
     * @return All logs
     */
    @Override
    public List<? extends ILog> getAllLogs() {
        return Persistence.getInstance().getPersistenceFacade().getLogs();
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
        Persistence.getInstance().getPersistenceFacade().addLog(log);
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
        Persistence.getInstance().getPersistenceFacade().addAttemptLog(log);
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
        Persistence.getInstance().getPersistenceFacade().addCaseLog(log);
    }
}
