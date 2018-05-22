package business.common;

import business.logic.Department;
import common.ICase;
import common.ICaseWorker;
import common.ICitizenData;
import common.IDepartment;
import java.util.List;

/**
 * Contains the interface functionality for the LogicFacade
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface ILogicFacade {

    /**
     * Opens an case with citizen data
     *
     * @param citizenData The citizen data to open an case with
     * @return The newly opened case
     */
    ICase openCase(ICitizenData citizenData);

    /**
     * Closes a case from a given case id
     *
     * @param caseId The case id to find a case from
     * @return True if the case is closed
     */
    boolean closeCase(int caseId);

    /**
     * Finds an active case with a specific case id
     *
     * @param caseId The value of case id
     * @return An active case
     */
    ICase findActiveCase(int caseId);

    /**
     * Finds an active case with a specific citizen cpr
     *
     * @param cpr The citizen name
     * @return An active case with a specific citizen cpr
     */
    ICase findActiveCase(String cpr);

    /**
     * Gets a list of all active cases on the department
     *
     * @return A list of all active cases on the department
     */
    List<? extends ICase> getAllActiveCases();

    /**
     * Gets all of the active cases from the caseworker
     *
     * @return All of the active cases from the caseworker
     */
    List<? extends ICase> getActiveCases();

    /**
     * Sets the caseworker from an userId
     *
     * @param userId The userId to find a caseworker from
     */
    void setCaseWorker(String userId);

    /**
     * Removes the logged in caseworker
     */
    void removeCaseWorker();

    /**
     * Gets the current logged in case worker
     *
     * @return The current logged in case worker
     */
    ICaseWorker getCaseWorker();

    /**
     * Gets the department
     *
     * @return The department
     */
    IDepartment getDepartment();

    /**
     * Creates a new case worker
     *
     * @param name the name of the case worker
     * @param phoneNumber the phoneNumber of the caseworker
     * @param email the email address of the case worker
     * @param employeeId the employee id of the case worker
     * @param userId the user id of the case worker
     */
    void createCaseWorker(String name, String phoneNumber, String email, int employeeId, String userId);
    
    /**
     * Sets the department of the logged in user
     * @param department Which department to set
     */
    void setDepartment(IDepartment department);
}
