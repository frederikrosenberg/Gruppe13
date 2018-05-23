package business.logic;

import business.Persistence;
import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import common.ICitizenData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Contains information about a case worker
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class CaseWorker extends Person implements ICaseWorker {

    /**
     * Contains the deparments of the caseworker
     */
    private Department department;

    /**
     * The employees Id
     */
    private int employeeId;

    /**
     * The Users Id
     */
    private String userId;

    /**
     * The list of active cases the case worker owns
     */
    private List<Case> cases = new ArrayList();

    /**
     * Contructs a new case worker
     *
     * @param name The case workers name
     * @param phoneNumber The case workers phone number
     * @param email The case workers email
     * @param department The case workers department
     * @param employeeId The case workers employee id
     * @param userId The case workers user id
     * @param id The person id
     */
    public CaseWorker(String name, String phoneNumber, String email, Department department, int employeeId, String userId, int id) {
        super(name, phoneNumber, email, department.getName(), id);
        this.department = department;
        this.employeeId = employeeId;
        this.userId = userId;
    }

    /**
     * Constructs a case worker from an already existing case worker
     *
     * @param caseWorker The already existing case worker to extract data from
     * @param department The department the existing case worker works at
     */
    public CaseWorker(ICaseWorker caseWorker, Department department) {
        this(caseWorker.getName(), caseWorker.getPhoneNumber(), caseWorker.getEmail(), department, caseWorker.getEmployeeId(), caseWorker.getUserId(), caseWorker.getId());
    }

    /**
     * Opens a new case to the case worker
     *
     * @param data The data to put into the new case
     * @return The new case opened
     */
    public Case openCase(ICitizenData data) {
        Citizen citizen = null;
        for (ICitizen c : Persistence.getInstance().getPersistenceFacade().getCitizens(department.getName())) {
            if (c.getCpr().equals(data.getCitizen().getCpr())) {
                citizen = new Citizen(c);
                break;
            }
        }
        if (citizen == null) {
            citizen = new Citizen(data.getCitizen());
            int id = Persistence.getInstance().getPersistenceFacade().addCitizen(citizen);
            citizen.setId(id);
            citizen.setDepartmentName(department.getName());
            department.addCitizen(citizen);
        }
        Case c = new Case(data.getState(), data.getConsent(), data.getReason(), data.getAvailableOffers(), data.getSourceOfRequest(), citizen, this, department.getName());
        int caseId = Persistence.getInstance().getPersistenceFacade().addCase(c);
        c.setId(caseId);
        cases.add(c);
        return c;
    }

    /**
     * Closes an case
     *
     * @param caseId The case id of the case to close
     * @param finalComments The final comments
     * @param citizenRequires What the citizen requires
     * @param goalAchieved Is the goal achieved
     * @return True if the case is closed
     */
    public boolean closeCase(int caseId, String finalComments, String citizenRequires, boolean goalAchieved) {
        return Persistence.getInstance().getPersistenceFacade().closeCase(department.getName(), caseId, finalComments, citizenRequires, goalAchieved);
    }

    /**
     * Gets all the active cases
     *
     * @return All the active cases
     */
    public List<? extends ICase> getActiveCases() {
        return Persistence.getInstance().getPersistenceFacade().getCaseWorkersCases(department.getName(), getId());
    }

    /**
     * Gets the employee id
     *
     * @return The employee id
     */
    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Gets the user id
     *
     * @return The user id
     */
    @Override
    public String getUserId() {
        return userId;
    }
}
