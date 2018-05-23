package business.common;

import common.ILog;
import common.LogType;
import java.util.List;

/**
 * The interface for logging facade
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface ILoggingFacade {
    /**
     * Gets all logs from the given type
     * @param type The type of the logs to get
     * @return Allo logs form the given type
     */
    List<? extends ILog> getLogsOfType(LogType type);
    
    /**
     * Gets all logs
     * @return All logs
     */
    List<? extends ILog> getAllLogs();
    
    /**
     * Creates a normal log
     * @param type The type of the log
     * @param userId The user id who caused the log
     */
    void createLog(LogType type, String userId);
    
    /**
     * Creates a attempt login log
     * @param type The type of the log
     * @param username The username who tried to login
     */
    void createLoginAttemptLog(LogType type, String username);
    
    /**
     * Creates a case log
     * @param type The type of the log
     * @param userId The user id who caused the log
     * @param caseId The case id of the case this log is about
     * @param departmentName The department name
     */
    void createCaseLog(LogType type, String userId, int caseId, String departmentName);
}
