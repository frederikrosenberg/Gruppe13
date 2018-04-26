package persistence;

import common.ICaseWorker;
import common.IDepartment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores the data in the department
 * @author Frederik Rosenberg
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
    
    private List<DataCaseWorker> caseWorkers;
    
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
        caseWorkers = new ArrayList<>();
        for (ICaseWorker caseWorker : department.getCaseWorkers()) {
            caseWorkers.add(new DataCaseWorker(caseWorker));
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getTreatmentArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getPhoneNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * A list of all of the case workers in the department
     * @return a list of all the workers 
     */
    @Override
    public List<? extends ICaseWorker> getCaseWorkers() {
        return caseWorkers;
    }
    
}
