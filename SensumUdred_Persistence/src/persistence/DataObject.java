package persistence;

import common.IDataObject;
import common.IDepartment;
import common.IUserManager;
import java.io.Serializable;

/**
 * The object that stores all the information
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class DataObject implements IDataObject, Serializable {
    
    /**
     * The department that has been loaded or need to be saved
     */
    private DataDepartment department;
    
    /**
     * The users that has been loaded or needs to be saved
     */
    private DataUserManager userManager;
    
    /**
     * Constructor for data object
     * @param department loaded department or needed to be saved
     * @param userManager loaded user manager or needed to be saved
     */
    public DataObject(IDepartment department, IUserManager userManager) {
        this.department = new DataDepartment(department);
        this.userManager = new DataUserManager(userManager);
    }

    /**
     * Gets the department that has been loaded or needs to be saved
     * @return loaded/saved department
     */
    @Override
    public IDepartment getDepartment() {
        return department;
    }

    /**
     * Gets the user manager that has been loaded or needs to be saved
     * @return loaded/saved user manager
     */
    @Override
    public IUserManager getUserManager() {
        return userManager;
    }
    
}
