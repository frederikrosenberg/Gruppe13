package persistence;

import common.ICaseLog;
import common.LogType;
import java.util.Date;

/**
 * Data class for case log
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class DataCaseLog extends DataLog implements ICaseLog {
    
    /**
     * The case the log involves
     */
    private int caseId;
    
    private String departmentName;
    
    /**
     * Constructor for the case log
     * @param type the type of log
     * @param date the date of the log
     * @param userId the user id of the log
     * @param caseId the case id of the log
     * @param departmentName the department name
     */
    public DataCaseLog(LogType type, Date date, String userId, int caseId, String departmentName) {
        super(type, date, userId);
        this.caseId = caseId;
        this.departmentName = departmentName;
    }

    /**
     * Gets the case id for the case that is involved in the log
     * @return the case id
     */
    @Override
    public int getCaseId() {
        return caseId;
    }

    @Override
    public String getDepartmentName() {
        return departmentName;
    }
    
}
