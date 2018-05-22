package persistence;

import common.ICase;
import common.ICaseLog;
import common.ICaseWorker;
import common.ICitizen;
import common.IDepartment;
import common.ILog;
import common.ILoginAttemptLog;
import common.IPersistenceFacade;
import common.IUser;
import common.LogType;
import java.util.List;

/**
 * The facade the that business layer communicate with.
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class PersistenceFacade implements IPersistenceFacade {

     /**
     * Adds a user from a IUser and give the id from the database
     * @param user the given user
     * @return the id from the database
     */
    @Override
    public String addUser(IUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a case from a ICase and returns the id
     * @param _case the given case
     * @return the id from the database
     */
    @Override
    public int addCase(ICase _case) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a case worker from ICaseWorker and returns the id
     * Does not add
     * @param caseWorker the given case worker
     * @return the id from the database
     */
    @Override
    public int addCaseWorker(ICaseWorker caseWorker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a department from IDepartment and returns the id.
     * This does not add case workers, citizen or cases
     * @param department the given department
     * @return the id from the database
     */
    @Override
    public int addDeparment(IDepartment department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a citizen from ICitizen and returns the id
     * This does not add cases the citizen has
     * @param citizen the given citizen
     * @return the id from the database
     */
    @Override
    public int addCitizen(ICitizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a standard log from ILog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    @Override
    public int addLog(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a attempt log from IAttemptLog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    @Override
    public int addAttemptLog(ILoginAttemptLog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /**
     * Adds a case log from ICaseLog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    @Override
    public int addCaseLog(ICaseLog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the logs from the database
     * @return the logs
     */
    @Override
    public List<ILog> getLogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the logs with at given type
     * @param type the type of log
     * @return the logs of that type
     */
    @Override
    public List<ILog> getLogsOfType(LogType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get a specific case
     * @param caseId the case id
     * @return the given case with the id, or null if the case does not exist 
     */
    @Override
    public ICase getCase(int caseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the cases
     * @return all the cases
     */
    @Override
    public List<ICase> getAllCases() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Get all the cases belonging to that case worker
     * @param caseWorkerId the id of the case worker
     * @return the cases for the case worker, empty if the case worker does not exist
     */
    @Override
    public List<ICase> getCaseWorkersCases(int caseWorkerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get a specific user
     * @param userId the id of the user
     * @return the given user or null if the user does not exist
     */
    @Override
    public IUser getUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the users
     * @return all the users
     */
    @Override
    public List<IUser> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get a specific citizen
     * @param id the id of the citizen
     * @return the given citizen or null if the citizen does not exist
     */
    @Override
    public ICitizen getCitizen(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the citizens
     * @return all the citizens 
     */
    @Override
    public List<ICitizen> getCitizens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get a specific department
     * @param id the given id
     * @return the specific department or null if the department does not exist
     */
    @Override
    public IDepartment getDepartment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
