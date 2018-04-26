package persistence;

import common.IDataObject;
import common.IDepartment;
import common.IUserManager;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fsr19
 */
public class DataObject implements IDataObject, Serializable {
    /**
     * 
     */
    private DataDepartment department;
    
    /**
     * 
     */
    private DataUserManager userManager;
    
    /**
     * 
     * @param department
     * @param userManager 
     */
    public DataObject(IDepartment department, IUserManager userManager) {
        
    }

    /**
     * 
     * @return 
     */
    @Override
    public IDepartment getDepartment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public IUserManager getUserManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
