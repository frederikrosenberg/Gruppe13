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
     * The department name
     */
    private String departmentName;
    
    /**
     * Constructs a case log
     * @param caseId The case id
     * @param logType The log type
     * @param userId  The user id
     * @param departmentName The department name
     */
    public CaseLog(int caseId, LogType logType, String userId, String departmentName) {
        super(logType, userId);
        this.caseId = caseId;
        this.departmentName = departmentName;
    }
    
    /**
     * Gets the case id
     * @return The case id
     */
    @Override
    public int getCaseId() {
        return caseId;
    }

    /**
     * Gets the department name
     * @return The department name
     */
    @Override
    public String getDepartmentName() {
        return departmentName;
    }
    
}
