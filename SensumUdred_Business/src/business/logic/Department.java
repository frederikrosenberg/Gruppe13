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
    
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTreatmentArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPhoneNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ICaseWorker> getCaseWorkers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
