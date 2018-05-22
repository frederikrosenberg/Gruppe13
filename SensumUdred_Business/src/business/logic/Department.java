package business.logic;

import business.Persistence;
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
        this(department.getName(), department.getTreatmentArea(), department.getAddress(), department.getEmail(), department.getPhoneNumber());
        citizens = new ArrayList<>();
        caseWorkers = new ArrayList<>();
        inactiveCases = new ArrayList<>();
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
        return new CaseWorker(Persistence.getInstance().getPersistenceFacade().getCaseworker(name, id), this);
    }

    /**
     * Find a citizen
     *
     * @param id of the citizen
     * @return the found citizen
     */
    public Citizen findCitizen(int id) {
        return new Citizen(Persistence.getInstance().getPersistenceFacade().getCitizen(name, id));
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
        return Persistence.getInstance().getPersistenceFacade().getCaseworkers(name);
    }

    /**
     * Gets a list of all of the active cases on the department
     *
     * @return All of the active cases on the department
     */
    @Override
    public List<? extends ICase> getAllActiveCases() {
        return Persistence.getInstance().getPersistenceFacade().getAllCases(name);
    }

    /**
     * Finds an active case from a case id
     *
     * @param caseId The case id
     * @return An active case
     */
    public ICase findActiveCase(int caseId) {
        return Persistence.getInstance().getPersistenceFacade().getCase(name, caseId);
    }

    /**
     * Finds an active case with the name of the citizen
     *
     * @param cpr The name to search for
     * @return The active case
     */
    public ICase findActiveCase(String cpr) {
        return Persistence.getInstance().getPersistenceFacade().getCase(name, cpr);
    }

    /**
     * Gets a list of all of the inactive cases on the department
     *
     * @return All of the inactive cases on the department
     */
    @Override
    public List<? extends ICase> getInactiveCases() {
        return Persistence.getInstance().getPersistenceFacade().getAllInactiveCases(name);
    }

    /**
     * Gets a list of all of the citizens in the department
     *
     * @return A list of all of the citizens in the department
     */
    @Override
    public List<? extends ICitizen> getCitizens() {
        return Persistence.getInstance().getPersistenceFacade().getCitizens(name);
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
        ICaseWorker caseWorker = new CaseWorker(name, phoneNumber, email, this, employeeId, userId);
        Persistence.getInstance().getPersistenceFacade().addCaseWorker(caseWorker);
        caseWorkers.add((CaseWorker) caseWorker);
    }
    
    /**
     * Adds a citizen to the list of citizens for the department
     * @param citizen the given citizen
     */
    public void addCitizen(Citizen citizen) {
        Persistence.getInstance().getPersistenceFacade().addCitizen((ICitizen) citizen);
        citizens.add(citizen);
    }

}
