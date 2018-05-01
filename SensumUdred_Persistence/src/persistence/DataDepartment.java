package persistence;

import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import common.IDepartment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores the data in the department
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class DataDepartment implements IDepartment, Serializable {
    
    /**
     * The name of the department
     */
    private String name;
    
    /**
     * The treatment area the department can handle
     */
    private String treatmentArea;
    
    /**
     * The address of the department 
     */
    private String address;
    
    /**
     * The email for the department
     */
    private String email;
    
    /**
     * The phone number of the department
     */
    private String phoneNumber;
    
    /**
     * The citizens on the department
     */
    private List<DataCitizen> citizens;
    
    /**
     * The case workers that works at that department
     */
    private List<DataCaseWorker> caseWorkers;
    
    /**
     * A list of inactive/closed cases
     */
    private List<ICase> inactiveCases;
    
    /**
     * The constructor for the data department
     * @param department the data of the department from the business layer
     */
    public DataDepartment(IDepartment department) {
        name = department.getName();
        treatmentArea = department.getTreatmentArea();
        address = department.getAddress();
        email = department.getEmail();
        phoneNumber = department.getPhoneNumber();
        
        citizens = new ArrayList<>();
        for (ICitizen citizen : department.getCitizens()) {
            citizens.add(new DataCitizen(citizen));
        }
        
        caseWorkers = new ArrayList<>();
        for (ICaseWorker caseWorker : department.getCaseWorkers()) {
            caseWorkers.add(new DataCaseWorker(caseWorker, this));
        }
        
        inactiveCases = new ArrayList<>();
        for (ICase inactiveCase : department.getInactiveCases()) {
            inactiveCases.add(new DataCase(inactiveCase, findCaseWorker(inactiveCase.getCaseWorker().getUserId()), findCitizen(inactiveCase.getCitizen().getCpr()), false));
        }
    }
    
    /**
     * Find a case worker
     * @param id of the case worker
     * @return the found case worker
     * @throws IllegalArgumentException if not found, because this should be found while saving otherwise something is missing
     */
    private DataCaseWorker findCaseWorker(String id) {
        for (DataCaseWorker worker : caseWorkers) {
            if (worker.getUserId().equals(id)) return worker;
        }
        throw new IllegalArgumentException();
    }
    
    /**
     * Find a citizen 
     * @param cpr of the citizen
     * @return the found citizen
     * @throws IllegalArgumentException if not found, because this should be found while saving otherwise something is missing
     */
    public DataCitizen findCitizen(int cpr) {
        for (DataCitizen citizen : citizens) {
            if (citizen.getCpr() == cpr) return citizen;
        }
        throw new IllegalArgumentException();
    }
    
    
    

    /**
     * The name of department
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * The treatment area the department takes care of
     * @return the treatment area
     */
    @Override
    public String getTreatmentArea() {
        return treatmentArea;
    }

    /**
     * The address of the department
     * @return the address
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * The email for the depart
     * @return the email
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * The phone number for the department
     * @return the phone number
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * A list of all of the case workers in the department
     * @return a list of all the workers 
     */
    @Override
    public List<? extends ICaseWorker> getCaseWorkers() {
        return caseWorkers;
    }

    /**
     * Gets all the active cases
     * @return null
     * @throws UnsupportedOperationException since this function is not meant to be called on the data class
     */
    @Override
    public List<? extends ICase> getAllActiveCases() {
        throw new UnsupportedOperationException("Not supported on data class");
    }

    /**
     * Get all the citizens that are being handled by the department
     * @return the citizens
     */
    @Override
    public List<? extends ICitizen> getCitizens() {
        return citizens;
    }

    /**
     * Gets a list of inactive cases
     * @return inactive cases
     */
    @Override
    public List<? extends ICase> getInactiveCases() {
        return inactiveCases;
    }
    
}
