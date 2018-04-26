package persistence;

import common.ICaseWorker;
import java.io.Serializable;

/**
 * The class for holding data of the case worker
 * @author Frederik Rosenberg
 */
public class DataCaseWorker extends DataPerson implements ICaseWorker, Serializable {

    /**
     * The user id of the user connected to this case worker
     */
    private String userId;
    
    /**
     * The employee id of the case worker
     */
    private int employeeId;
    
    
    public DataCaseWorker(ICaseWorker caseWorker) {
        super(caseWorker);
        userId = caseWorker.getUserId();
        employeeId = caseWorker.getEmployeeId();
    }

    /**
     * The employee id of the case worker
     * @return the employee id
     */
    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * The user id of the user connected to this case worker
     * @return the user id
     */
    @Override
    public String getUserId() {
        return userId;
    }
    
}
