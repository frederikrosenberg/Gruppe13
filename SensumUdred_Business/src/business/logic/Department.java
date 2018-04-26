package business.logic;

import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import common.IDepartment;
import java.util.List;

/**
 *
 * @author andreasmolgaard-andersen
 */
public class Department implements IDepartment {

    private List<ICaseWorker> caseWorkers;
    private List<ICase> inactiveCases;
    private List<ICitizen> citizens;
    private String name;
    private String treatmentArea;
    private String address;
    private String email;
    private String phoneNumber;
    
    public Department(IDepartment department) {
        caseWorkers = department.getCaseWorkers();
        name = department.getName();
        treatmentArea = department.getTreatmentArea();
        address = department.getAddress();
        email = department.getEmail();
        phoneNumber = department.getPhoneNumber();
    }

    public Department(String name, String treatmentArea, String address, String email, String phoneNumber) {
        this.name = name;
        this.treatmentArea = treatmentArea;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getTreatmentArea() {
        return this.treatmentArea;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public List<ICaseWorker> getCaseWorkers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
