package business;

import business.Logging.LoggingFacade;
import business.common.ILogicFacade;
import business.common.ISecurityFacade;
import business.logic.LogicFacade;
import business.security.SecurityFacade;
import common.IBusinessFacade;
import common.ICase;
import common.ICaseWorker;
import common.ICitizenData;
import common.IDataObject;
import common.ILog;
import common.IPersistenceFacade;
import common.LogType;
import common.Role;
import java.util.List;

/**
 * The facade of the business package
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class BusinessFacade implements IBusinessFacade {

    /**
     * Instance of the ILogicFacade
     */
    private ILogicFacade logic;

    /**
     * Instance of the ISecurityFacade
     */
    private ISecurityFacade security;

    /**
     * Instance of the IPersistenceFacade
     */
    public static IPersistenceFacade persistence;
    
    /**
     * Instance of the LoggingFacade
     */
    private LoggingFacade loggingFacade;

    /**
     * Constructor for the BusinessFacade
     */
    public BusinessFacade() {
        logic = new LogicFacade();
        security = new SecurityFacade();
    }

    /**
     * Logs the the user in, given that their information is valid
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return true if the log in was successful, else false
     */
    @Override
    public boolean login(String username, String password) {
        String id = security.logIn(username, password);
        if (id == null) {
            loggingFacade.createLoginAttemptLog(LogType.ATTEMPT_LOGIN, username);
            return false;
        }
        if (security.hasAccess(Role.CASEWORKER)) {
            logic.setCaseWorker(id);
        }
        loggingFacade.createLog(LogType.LOGIN, id);
        return true;
    }

    /**
     * Logs the user out
     *
     * @param isTimeout True if the logout was caused by a timeout
     * @return true.
     */
    @Override
    public boolean logOut(boolean isTimeout) {
        if (security.hasAccess(Role.CASEWORKER)) {
            logic.removeCaseWorker();
        }
        if(isTimeout) {
            loggingFacade.createLog(LogType.TIMEOUT, security.getCurrentUser().getUserId());
        } else {
            loggingFacade.createLog(LogType.LOGOUT, security.getCurrentUser().getUserId());
        }
        security.logOut();
        return true;
    }

    /**
     * Opens a new case based on the entered data
     *
     * @param citizenData the information needed for the case
     * @return the newly opened case
     */
    @Override
    public ICase openCase(ICitizenData citizenData) {
        if (security.hasAccess(Role.CASEWORKER)) {
            ICase temp = logic.openCase(citizenData);
            loggingFacade.createCaseLog(LogType.OPEN_CASE, security.getCurrentUser().getUserId(), temp.getId());
            return temp;
        }
        return null;
    }

    /**
     * Closes a case from a given case id
     *
     * @param caseId The case to close
     * @return True if the case is closed
     */
    @Override
    public boolean closeCase(int caseId) {
        if (security.hasAccess(Role.CASEWORKER)) {
            if(logic.closeCase(caseId)) {
                loggingFacade.createCaseLog(LogType.CLOSE_CASE, security.getCurrentUser().getUserId(), caseId);
                return true;
            }
        }
        return false;
    }

    /**
     * To be called when the system shuts down
     */
    @Override
    public void closing() {
        save();
    }

    /**
     * Finds an active case from either cpr or case id
     *
     * @param value the search parameter
     * @param isCpr if true the value is cpr otherwise it is case id
     * @return the case found, else null
     */
    @Override
    public ICase findActiveCase(int value, boolean isCpr) {
        if (security.hasAccess(Role.CASEWORKER)) {
            ICase temp = logic.findActiveCase(value, isCpr);
            loggingFacade.createCaseLog(LogType.CASE_VIEWED, security.getCurrentUser().getUserId(), temp.getId());
            return temp;
        }
        return null;
    }

    /**
     * Finds an active case from the name of the concerned citizen
     *
     * @param name the name of the concerned citizen
     * @return the case found, else null
     */
    @Override
    public ICase findActiveCase(String name) {
        if (security.hasAccess(Role.CASEWORKER)) {
            ICase temp = logic.findActiveCase(name);
            loggingFacade.createCaseLog(LogType.CASE_VIEWED, security.getCurrentUser().getUserId(), temp.getId());
            return temp;
        }
        return null;
    }

    /**
     * Returns all active cases in the department
     *
     * @return all active cases in the department
     */
    @Override
    public List<? extends ICase> getAllActiveCases() {
        if (security.hasAccess(Role.CASEWORKER)) {
            loggingFacade.createLog(LogType.VIEW_ALL_CASES, security.getCurrentUser().getUserId());
            return logic.getAllActiveCases();
        }
        return null;
    }

    /**
     * Returns all active cases of the current caseworker
     *
     * @return all active cases of the current caseworker
     */
    @Override
    public List<? extends ICase> getActiveCases() {
        if (security.hasAccess(Role.CASEWORKER)) {
            loggingFacade.createLog(LogType.VIEW_CASEWORKERS_CASES, security.getCurrentUser().getUserId());
            return logic.getActiveCases();
        }
        return null;
    }

    /**
     * Injects a reference to the persistence layer
     *
     * @param persistence the reference to be injected
     */
    @Override
    public void injectPersistence(IPersistenceFacade persistence) {
        this.persistence = persistence;
        Persistence.getInstance().injectPersistence(persistence);
        loggingFacade = new LoggingFacade(persistence);
        load();
    }

    /**
     * Gets the current logged in case worker
     *
     * @return The current logged in case worker
     */
    @Override
    public ICaseWorker getCaseWorker() {
        if (security.hasAccess(Role.CASEWORKER)) {
            return logic.getCaseWorker();
        }
        return null;
    }

    /**
     * Loads in the saved data if any is available, otherwise generates dummy
     * data
     *
     */
    private void load() {
       /* if (persistence.saveAvailable()) {
            IDataObject data = persistence.load();
            logic = new LogicFacade(data.getDepartment());
            security = new SecurityFacade(data.getUserManager());
        } else {
            //dummy data is added here
            logic = new LogicFacade("Dummy Department", "Dummy Syndrome", "Dummystreet 35", "dummy@dummymail.com", "12345678");
            security = new SecurityFacade();
            createCaseWorker("Dummy", "12345678", "dummy@dummymail.com", 12345, "Dummyuser", "password", Role.CASEWORKER);

        }*/
    }

    /**
     * Saves the data
     *
     * @return true if the data is saved
     */
    private boolean save() {
        return false; //persistence.save(security.getUserManager(), logic.getDepartment());
    }

    /**
     * Creates a new case worker
     *
     * @param name the name of the caseworker
     * @param phoneNumber the phone number of the case worker
     * @param email the email address of the case worker
     * @param employeeId the employee id of the case worker
     * @param username the username of the case worker
     * @param password the password of the case worker
     * @param role the role of the case workerS
     */
    private void createCaseWorker(String name, String phoneNumber, String email, int employeeId, String username, String password, Role role) {
        logic.createCaseWorker(name, phoneNumber, email, employeeId, security.addUser(name, username, password, role));

    }

    /**
     * Gets all logs
     * @return All logs
     */
    @Override
    public List<? extends ILog> getAllLogs() {
        loggingFacade.createLog(LogType.VIEW_LOG, security.getCurrentUser().getUserId());
        return loggingFacade.getAllLogs();
    }

    /**
     * Gets all logs of a given type
     * @param type The given type
     * @return All logs of a given type
     */
    @Override
    public List<? extends ILog> getLogsOfType(LogType type) {
        loggingFacade.createLog(LogType.VIEW_LOG, security.getCurrentUser().getUserId());
        return loggingFacade.getLogsOfType(type);
    }
    
}
