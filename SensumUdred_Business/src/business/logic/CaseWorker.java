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
     */
    public CaseWorker(String name, String phoneNumber, String email, Department department, int employeeId, String userId) {
        super(name, phoneNumber, email, department.getName());
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
        super(caseWorker.getName(), caseWorker.getPhoneNumber(), caseWorker.getEmail(), department.getName());
        this.employeeId = caseWorker.getEmployeeId();
        this.userId = caseWorker.getUserId();
        this.department = department;
        for (ICase activeCase : caseWorker.getActiveCases()) {
            Citizen citizen = department.findCitizen(activeCase.getCitizen().getId());
            Case c = new Case(activeCase, this, citizen, true);
            cases.add(c);
        }
    }

    /**
     * Opens a new case to the case worker
     *
     * @param data The data to put into the new case
     * @return The new case opened
     */
    public Case openCase(ICitizenData data) {
        ICitizen citizen = null;
        for (ICitizen c : Persistence.getInstance().getPersistenceFacade().getCitizens(department.getName())) {
            if (c.getCpr() == data.getCitizen().getCpr()) {
                citizen = (Citizen) c;
            }
        }
        if (citizen == null) {
            citizen = new Citizen(data.getCitizen());
            Persistence.getInstance().getPersistenceFacade().addCitizen(citizen);
            department.addCitizen((Citizen) citizen);
        }
        ICase c = new Case(data.getState(), data.getConsent(), data.getReason(), data.getAvailableOffers(), data.getSourceOfRequest(), (Citizen) citizen, this, department.getName());
        Persistence.getInstance().getPersistenceFacade().addCase(c);
        cases.add((Case) c);
        return (Case) c;
    }

    /**
     * Closes an case
     *
     * @param caseId The case id of the case to close
     * @return True if the case is closed
     */
    public boolean closeCase(int caseId) {
        Case aCase;
        for (Iterator<Case> itr = cases.iterator(); itr.hasNext();) {
            aCase = itr.next();
            if (aCase.getId() == caseId) {
                Persistence.getInstance().getPersistenceFacade().closeCase(department.getName(), caseId);
                aCase.closeCase();
                department.addInactiveCase(aCase);
                itr.remove();
            }
        }
        return true;
    }

    /**
     * Gets all the active cases
     *
     * @return All the active cases
     */
    public List<? extends ICase> getActiveCases() {
        return Persistence.getInstance().getPersistenceFacade().getCaseWorkersCases(department.getName(), employeeId);
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
