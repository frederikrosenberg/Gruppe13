package business.logic;

import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import common.IDepartment;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class Department implements IDepartment {

    private List<CaseWorker> caseWorkers;
    private List<Case> inactiveCases;
    private List<Citizen> citizens;
    private String name;
    private String treatmentArea;
    private String address;
    private String email;
    private String phoneNumber;
    
    /**
     * Constructor for loading a saved department
     * @param department The saved department
     */
    public Department(IDepartment department) {
        for (ICaseWorker caseWorker : department.getCaseWorkers()) {
            caseWorkers.add(new CaseWorker(caseWorker, this));
        }
        name = department.getName();
        treatmentArea = department.getTreatmentArea();
        address = department.getAddress();
        email = department.getEmail();
        phoneNumber = department.getPhoneNumber();
    }

    /**
     * Constructor for a new department
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
    }
    
    /**
     * Gets the name of the department
     * @return The name of the department
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the treatment area of the department
     * @return The treatment area of the department
     */
    @Override
    public String getTreatmentArea() {
        return this.treatmentArea;
    }

    /**
     * Gets the address of the department
     * @return The address of the department
     */
    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets the email of the department
     * @return The email of the department
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Gets the phone number of the department
     * @return The phone number of the department
     */
    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Gets a list of all of the case workers in the department
     * @return All of the case workers in the department
     */
    @Override
    public List<? extends ICaseWorker> getCaseWorkers() {
        return caseWorkers;
    }

    /**
     * Gets a list of all of the active cases on the department
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
     * Gets a list of all of the inactive cases on the department
     * @return All of the inactive cases on the department
     */
    @Override
    public List<? extends ICase> getInactiveCases() {
        return inactiveCases;
    }

    /**
     * Gets a list of all of the citizens in the department
     * @return A list of all of the citizens in the department
     */
    @Override
    public List<? extends ICitizen> getCitizens() {
        return citizens;
    }
    
    /**
     * Adds a case to the inactive case list
     * @param c The case to move
     */
    public void addInactiveCase(Case c) {
        inactiveCases.add(c);
    }
    
}
