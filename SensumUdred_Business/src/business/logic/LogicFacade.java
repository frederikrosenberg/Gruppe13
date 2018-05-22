package business.logic;

import business.Persistence;
import business.common.ILogicFacade;
import common.ICase;
import common.ICaseWorker;
import common.ICitizenData;
import common.IDepartment;
import java.util.List;

/**
 * The logicfacade that contains functionality about cases, citizen and case
 * workers
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
    
    public LogicFacade() {
        
    }

    /**
     * Creates a logic facade from a given department
     *
     * @param department The department to create a logic facade from
     */
    public LogicFacade(IDepartment department) {
        this.department = new Department(department);
    }

    public LogicFacade(String name, String treatmentArea, String address, String email, String phoneNumber) {
        department = new Department(name, treatmentArea, address, email, phoneNumber);
    }

    /**
     * Opens an case with a given citizen data
     *
     * @param citizenData The citizen data to open an case from
     * @return The newly opened case
     */
    @Override
    public ICase openCase(ICitizenData citizenData) {
        return caseWorker.openCase(citizenData);
    }

    /**
     * Closes an case from a given case id
     *
     * @param caseId The case id to close an case
     * @return True if the case is closed
     */
    @Override
    public boolean closeCase(int caseId) {
        return caseWorker.closeCase(caseId);
    }

    /**
     * Finds an active case with a specific citizen cpr or case id
     *
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
     *
     * @param name The citizen name
     * @return An active case with a specific citizen name
     */
    @Override
    public ICase findActiveCase(String name) {
        return department.findActiveCase(name);
    }

    /**
     * Gets a list of all active cases on the department
     *
     * @return A list of all active cases on the department
     */
    @Override
    public List<? extends ICase> getAllActiveCases() {
        return department.getAllActiveCases();
    }

    /**
     * Gets all of the active cases from the caseworker
     *
     * @return All of the active cases from the caseworker
     */
    @Override
    public List<? extends ICase> getActiveCases() {
        return caseWorker.getActiveCases();
    }

    /**
     * Sets the caseworker from an userId
     *
     * @param userId The userId to find a caseworker from
     */
    @Override
    public void setCaseWorker(String userId) {
        this.caseWorker = new CaseWorker(Persistence.getInstance().getPersistenceFacade().getCaseworker(department.getName(), userId), department);
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
     *
     * @return The department
     */
    @Override
    public IDepartment getDepartment() {
        return department;
    }

    /**
     * Gets the current logged in case worker
     *
     * @return The current logged in case worker
     */
    @Override
    public ICaseWorker getCaseWorker() {
        return caseWorker;
    }

    /**
     * Creates a new case worker
     *
     * @param name the name of the case worker
     * @param phoneNumber the phoneNumber of the caseworker
     * @param email the email address of the case worker
     * @param employeeId the employee id of the case worker
     * @param userId the user id of the case worker
     */
    @Override
    public void createCaseWorker(String name, String phoneNumber, String email, int employeeId, String userId) {
        department.addCaseWorker(name, phoneNumber, email, employeeId, userId);
    }
}
