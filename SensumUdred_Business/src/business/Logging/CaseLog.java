package business.Logging;

import common.ICaseLog;
import common.LogType;

/**
 * The case log
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class CaseLog extends Log implements ICaseLog {

     /**
     * Contains the case id
     */
    private int caseId;
    
    /**
     * Constructs a case log
     * @param caseId The case id
     * @param logType The log type
     * @param userId  The user id
     */
    public CaseLog(int caseId, LogType logType, String userId) {
        super(logType, userId);
        this.caseId = caseId;
    }
    
    /**
     * Gets the case id
     * @return The case id
     */
    @Override
    public int getCaseId() {
        return caseId;
    }
    
}
