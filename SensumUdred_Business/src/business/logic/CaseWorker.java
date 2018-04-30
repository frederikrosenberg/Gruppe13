package business.logic;

import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import common.ICitizenData;
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
public class CaseWorker extends Person implements ICaseWorker{

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
    private List<Case> cases;
    
    /**
     * Contructs a new case worker
     * @param name The case workers name
     * @param phoneNumber The case workers phone number
     * @param email The case workers email
     * @param department The case workers department
     * @param employeeId The case workers employee id
     * @param userId The case workers user id
     */
    public CaseWorker(String name, String phoneNumber, String email, Department department, int employeeId, String userId) {
        super(name, phoneNumber, email);
        this.department = department;
        this.employeeId = employeeId;
        this.userId = userId;
    }
    
    /**
     * Constructs a case from an already existing case worker
     * @param caseWorker The already existing case worker to extract data from
     * @param department The department the existing case worker works at
     */
    public CaseWorker(ICaseWorker caseWorker, Department department) {
        super(caseWorker.getName(), caseWorker.getPhoneNumber(), caseWorker.getEmail());
        this.employeeId = caseWorker.getEmployeeId();
        this.userId = caseWorker.getUserId();
        this.department = department;
    }

    /**
     * Opens a new case to the case worker
     * @param data The data to put into the new case
     * @return The new case opened
     */
    public Case openCase(ICitizenData data) {
        List<? extends ICitizen> citizens = department.getCitizens();
        Citizen citizen = null;
        for (ICitizen c : citizens) {
            if(c.getCpr() == data.getCitizen().getCpr()) {
                citizen = (Citizen) c;
            }
        }
        if(citizen == null) {
            citizen = new Citizen(data.getCitizen());
        }
        Case c = new Case(data.getState(), data.getConsent(), data.getReason(), data.getAvailableOffers(), data.getSourceOfRequest(), citizen, this);
        cases.add(c);
        return c;
    }
    
    /**
     * Closes an case
     * @param caseId The case id of the case to close
     * @return True if the case is closed
     */
    public boolean closeCase(int caseId) {
        for (Case aCase : cases) {
            if(aCase.getId() == caseId) {
                aCase.closeCase();
                department.addInactiveCase(aCase);
                cases.remove(aCase);
            }
        }
        return true;
    }
    
    /**
     * Edit an already existing case
     * @param data The data to change
     * @return True if the case is changed
     */
    public boolean editCase(Case c, ICitizenData data) {
        c.setAvailableOffers(data.getAvailableOffers());
        c.setCaseWorker((CaseWorker)data.getCaseWorker());
        c.setCitizen((Citizen)data.getCitizen());
        c.setConsent(data.getConsent());
        c.setReason(data.getReason());
        c.setSourceOfReqeust(data.getSourceOfRequest());
        c.setState(data.getState());
        return true;
    }
    
    /**
     * Gets all the active cases
     * @return All the active cases
     */
    public List<? extends ICase> getActiveCases() {
        return cases;
    }
    
    /**
     * Gets the employee id
     * @return The employee id
     */
    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Gets the user id
     * @return The user id
     */
    @Override
    public String getUserId() {
        return userId;
    }
    
}
