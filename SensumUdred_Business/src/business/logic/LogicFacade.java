package business.logic;

import business.common.ILogicFacade;
import common.ICase;
import common.ICaseWorker;
import common.ICitizenData;
import common.IDepartment;
import java.util.List;

/**
 * The logicfacade that contains functionality about cases, citizen and case workers
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class LogicFacade implements ILogicFacade {
    
    /**
     * The department
     */
    private Department department;
    /**
     * The logged in caseworker
     */
    private CaseWorker caseWorker;

    /**
     * Creates an logicfacde from a given deparment
     * @param department The deparment to create a logicfacade from
     */
    public LogicFacade(IDepartment department) {
        this.department = (Department) department;
    }
    
    public LogicFacade() {
        // TODO Insert dummy data to empty logicFacade
    }
    
    /**
     * Opens an case with a given citizen data
     * @param citizenData The citizen data to open an case from
     * @return The newly opened case
     */
    @Override
    public ICase openCase(ICitizenData citizenData) {
        return caseWorker.openCase(citizenData);
    }

    /**
     * Closes an case from a given case id
     * @param caseId The case id to close an case
     * @return True if the case is closed
     */
    @Override
    public boolean closeCase(int caseId) {
        return caseWorker.closeCase(caseId);
    }

    /**
     * Finds an active case with a specific citizen cpr or case id
     * @param value The value of cpr/case id
     * @param isCpr True if its a cpr
     * @return An active case
     */
    @Override
    public ICase findActiveCase(int value, boolean isCpr) {
        return department.findActiveCase(value, isCpr);
    }

    /**
     * Finds an active case with a specific citizen name
     * @param name The citizen name
     * @return An active case with a specific citizen name
     */
    @Override
    public ICase findActiveCase(String name) {
        return department.findActiveCase(name);
    }

    /**
     * Gets a list of all active cases on the department
     * @return A list of all active cases on the department
     */
    @Override
    public List<? extends ICase> getAllActiveCases() {
        return department.getAllActiveCases();
    }

    /**
     * Gets all of the active cases from the caseworker
     * @return All of the active cases from the caseworker
     */
    @Override
    public List<? extends ICase> getActiveCases() {
       return caseWorker.getActiveCases();
    }

    /**
     * Sets the caseworker from an userId
     * @param userId The userId to find a caseworker from
     */
    @Override
    public void setCaseWorker(String userId) {
        for (ICaseWorker caseWorker : department.getCaseWorkers()) {
            if(caseWorker.getUserId().equals(userId)) this.caseWorker = (CaseWorker) caseWorker;
        }
    }

    /**
     * Removes the logged in caseworker
     */
    @Override
    public void removeCaseWorker() {
        this.caseWorker = null;
    }

    /**
     * Gets the department
     * @return The department
     */
    @Override
    public IDepartment getDepartment() {
        return department;
    }
}
