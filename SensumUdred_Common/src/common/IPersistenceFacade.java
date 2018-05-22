package common;

import java.util.List;

/**
 * The interface for the Persistence interface.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface IPersistenceFacade {
    
    /**
     * Adds a user from a IUser and give the id from the database
     * @param user the given user
     * @return the id from the database
     */
    String addUser(IUser user);
    
    /**
     * Adds a case from a ICase and returns the id
     * @param _case the given case
     * @return the id from the database
     */
    int addCase(ICase _case);
    
    /**
     * Adds a case worker from ICaseWorker and returns the id
     * Does not add
     * @param caseWorker the given case worker
     * @return the id from the database
     */
    int addCaseWorker(ICaseWorker caseWorker);
    
    /**
     * Adds a department from IDepartment and returns the id.
     * This does not add case workers, citizen or cases
     * @param department the given department
     * @return the id from the database
     */
    String addDeparment(IDepartment department);
    
    /**
     * Adds a citizen from ICitizen and returns the id
     * This does not add cases the citizen has
     * @param citizen the given citizen
     * @return the id from the database
     */
    int addCitizen(ICitizen citizen);
    
    /**
     * Adds a standard log from ILog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    int addLog(ILog log);
    
    /**
     * Adds a attempt log from IAttemptLog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    int addAttemptLog(ILoginAttemptLog log);
    
    /**
     * Adds a case log from ICaseLog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    int addCaseLog(ICaseLog log);
    
    /**
     * Get all the logs from the database
     * @return the logs
     */
    List<? extends ILog> getLogs();
    
    /**
     * Get all the logs with at given type
     * @param type the type of log
     * @return the logs of that type
     */
    List<? extends ILog> getLogsOfType(LogType type);
    
    /**
     * Get a specific case
     * @param caseId the case id
     * @return the given case with the id, or null if the case does not exist 
     */
    ICase getCase(String department, int caseId);
    
    /**
     * Gets a specific case from a citizen cpr
     * @param name The citizen cpr
     * @return A specific case from a citizen cpr
     */
    ICase getCase(String department, String cpr);
    
    /**
     * Get all the cases from a department
     * @param departmentName The department name
     * @return all the cases
     */
    List<? extends ICase> getAllCases(String departmentName);
    
    /**
     * Gets all inactive cases from a department
     * @param departmentName The department name
     * @return All inactice cases from a department
     */
    List<? extends ICase> getAllInactiveCases(String departmentName);
    
    /**
     * Get all the cases belonging to that case worker
     * @param caseWorkerId the id of the case worker
     * @return the cases for the case worker, empty if the case worker does not exist
     */
    List<? extends ICase> getCaseWorkersCases(String department, int caseWorkerId);
    
    /**
     * Get a specific user
     * @param userId the id of the user
     * @return the given user or null if the user does not exist
     */
    IUser getUser(String userId);
    
    /**
     * Get all the users
     * @return all the users
     */
    List<? extends IUser> getUsers();
    
    /**
     * Get a specific citizen
     * @param id the id of the citizen
     * @return the given citizen or null if the citizen does not exist
     */
    ICitizen getCitizen(String department, int id);
    
    /**
     * Get all the citizens from a department
     * @param departmentName The department name
     * @return all the citizens 
     */
    List<? extends ICitizen> getCitizens(String departmentName);
    
    /**
     * Get a specific department
     * @param departmentName the given id
     * @return the specific department or null if the department does not exist
     */
    IDepartment getDepartment(String departmentName);
    
    /**
     * Closes a case
     * @param caseId The case to close
     * @return True if the case is closed
     */
    boolean closeCase(String departmentName, int caseId);
  
    /**
     * Gets all the caseworkers from a department
     * @param departmentName Which department to get from
     * @return All the caseworkers from a department
     */
    List<? extends ICaseWorker> getCaseworkers(String departmentName);
    
    /**
     * Gets a caseworker
     * @param departmentName The department name
     * @param userId The caseworkers person id
     * @return A caseworker
     */
    ICaseWorker getCaseworker(String departmentName, String userId);
}
