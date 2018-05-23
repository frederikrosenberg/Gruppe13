package business.logic;

import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import common.IDepartment;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains information about a department
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class Department implements IDepartment {

    /**
     * List of all the caseworkers in the department
     */
    private List<CaseWorker> caseWorkers;

    /**
     * List of all of the inactive cases from this department
     */
    private List<Case> inactiveCases;

    /**
     * List of all of the citizens in the department
     */
    private List<Citizen> citizens;

    /**
     * Name of the department
     */
    private String name;

    /**
     * The treatment area of the department
     */
    private String treatmentArea;

    /**
     * The address of the department
     */
    private String address;

    /**
     * The email of the department
     */
    private String email;

    /**
     * The phone number of the department
     */
    private String phoneNumber;

    /**
     * Constructor for loading a saved department
     *
     * @param department The saved department
     */
    public Department(IDepartment department) {
        citizens = new ArrayList<>();
        for (ICitizen citizen : department.getCitizens()) {
            citizens.add(new Citizen(citizen));
        }

        caseWorkers = new ArrayList<>();
        for (ICaseWorker caseWorker : department.getCaseWorkers()) {
            caseWorkers.add(new CaseWorker(caseWorker, this));
        }

        inactiveCases = new ArrayList<>();
        for (ICase inactiveCase : department.getInactiveCases()) {
            inactiveCases.add(new Case(inactiveCase, findCaseWorker(inactiveCase.getCaseWorker().getUserId()), findCitizen(inactiveCase.getCitizen().getCpr()), false));
        }
        name = department.getName();
        treatmentArea = department.getTreatmentArea();
        address = department.getAddress();
        email = department.getEmail();
        phoneNumber = department.getPhoneNumber();
    }

    /**
     * Constructor for a new department
     *
     * @param name Name of the department
     * @param treatmentArea Which treatment area the department works with
     * @param address The address of the department
     * @param email The email address for the department
     * @param phoneNumber The phone number for the department
     */
    public Department(String name, String treatmentArea, String address, String email, String phoneNumber) {
        this.name = name;
        this.treatmentArea = treatmentArea;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        citizens = new ArrayList();
        caseWorkers = new ArrayList();
        inactiveCases = new ArrayList();
    }

    /**
     * Find a case worker
     *
     * @param id of the case worker
     * @return the found case worker
     */
    private CaseWorker findCaseWorker(String id) {
        for (CaseWorker worker : caseWorkers) {
            if (worker.getUserId().equals(id)) {
                return worker;
            }
        }
        return null;
    }

    /**
     * Find a citizen
     *
     * @param cpr of the citizen
     * @return the found citizen
     */
    public Citizen findCitizen(int cpr) {
        for (Citizen citizen : citizens) {
            if (citizen.getCpr() == cpr) {
                return citizen;
            }
        }
        return null;
    }

    /**
     * Gets the name of the department
     *
     * @return The name of the department
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the treatment area of the department
     *
     * @return The treatment area of the department
     */
    @Override
    public String getTreatmentArea() {
        return treatmentArea;
    }

    /**
     * Gets the address of the department
     *
     * @return The address of the department
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Gets the email of the department
     *
     * @return The email of the department
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Gets the phone number of the department
     *
     * @return The phone number of the department
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets a list of all of the case workers in the department
     *
     * @return All of the case workers in the department
     */
    @Override
    public List<? extends ICaseWorker> getCaseWorkers() {
        return caseWorkers;
    }

    /**
     * Gets a list of all of the active cases on the department
     *
     * @return All of the active cases on the department
     */
    @Override
    public List<? extends ICase> getAllActiveCases() {
        List<ICase> cases = new ArrayList();
        for (CaseWorker caseWorker : caseWorkers) {
            cases.addAll(caseWorker.getActiveCases());
        }
        return cases;
    }

    /**
     * Finds an active case from either a cpr number or a case id
     *
     * @param value The cpr/case id
     * @param isCpr True if it should search for a cpr
     * @return An active case
     */
    public ICase findActiveCase(int value, boolean isCpr) {
        for (ICase activeCase : getAllActiveCases()) {
            if (isCpr) {
                if (value == activeCase.getCitizen().getCpr()) {
                    return activeCase;
                }
            } else {
                if (value == activeCase.getId()) {
                    return activeCase;
                }
            }
        }
        return null;
    }

    /**
     * Finds an active case with the name of the citizen
     *
     * @param name The name to search for
     * @return The active case
     */
    public ICase findActiveCase(String name) {
        for (ICase activeCase : getAllActiveCases()) {
            if (name.toLowerCase().equals(activeCase.getCitizen().getName().toLowerCase())) {
                return activeCase;
            }
        }
        return null;
    }

    /**
     * Gets a list of all of the inactive cases on the department
     *
     * @return All of the inactive cases on the department
     */
    @Override
    public List<? extends ICase> getInactiveCases() {
        return inactiveCases;
    }

    /**
     * Gets a list of all of the citizens in the department
     *
     * @return A list of all of the citizens in the department
     */
    @Override
    public List<? extends ICitizen> getCitizens() {
        return citizens;
    }

    /**
     * Adds a case to the inactive case list
     *
     * @param c The case to move
     */
    public void addInactiveCase(Case c) {
        inactiveCases.add(c);
    }

    /**
     * Adds a new case worker to the department
     *
     * @param name the name of the case worker
     * @param phoneNumber the phoneNumber of the case worker
     * @param email the email address of the case worker
     * @param employeeId the employee id of the case worker
     * @param userId the user id of the caseworker
     */
    public void addCaseWorker(String name, String phoneNumber, String email, int employeeId, String userId) {
        CaseWorker caseWorker = new CaseWorker(name, phoneNumber, email, this, employeeId, userId);
        caseWorkers.add(caseWorker);
    }
    
    /**
     * Adds a citizen to the list of citizens for the department
     * @param citizen the given citizen
     */
    public void addCitizen(Citizen citizen) {
        citizens.add(citizen);
    }

}
