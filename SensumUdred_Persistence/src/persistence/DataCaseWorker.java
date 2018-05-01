package persistence;

import common.ICase;
import common.ICaseWorker;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The class for holding data of the case worker
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
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
    
    /**
     * Current active cases that this case worker is assigned
     */
    private List<DataCase> cases;
    
    /**
     * Constructor for data case worker
     * @param caseWorker the data about the case worker
     * @param department the department for finding the citizens
     */
    public DataCaseWorker(ICaseWorker caseWorker, DataDepartment department) {
        super(caseWorker);
        userId = caseWorker.getUserId();
        employeeId = caseWorker.getEmployeeId();
        
        cases = new ArrayList<>();
        for (ICase activeCase : caseWorker.getActiveCases()) {
            DataCitizen citizen = department.findCitizen(activeCase.getCitizen().getCpr());
            DataCase _case = new DataCase(activeCase, this, citizen, true);
            cases.add(_case);
        }
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

    /**
     * Get the active cases
     * @return the cases
     */
    @Override
    public List<? extends ICase> getActiveCases() {
        return cases;
    }
    
}
