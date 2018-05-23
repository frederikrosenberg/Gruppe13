package common;

import java.util.List;

/**
 * The interface for the facade of the business layer, responsible for communication between GUI
 * and the business layer
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface IBusinessFacade {

    /**
     * Logs the the user in, given that their information is valid
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return true if the log in was successful, else false
     */
    boolean login(String username, String password);

    /**
     * Logs the user out.
     *
     * @param isTimeout True if the log out was caused by a timeout
     * @return true.
     */
    boolean logOut(boolean isTimeout);

    /**
     * Opens a new case based on the entered data
     *
     * @param citizenData the information needed for the case
     * @return the newly opened case
     */
    ICase openCase(ICitizenData citizenData);

    /**
     * Closes a case from a given case id
     * @param caseId The case to close
     * @param finalComments The final comment to the case
     * @param citizenRequires What the citizen requires
     * @param goalAchieved Is the goal achieved
     * @return True if the case is closed
     */
    boolean closeCase(int caseId, String finalComments, String citizenRequires, boolean goalAchieved);

    /**
     * To be called when the system shuts down.
     */
    void closing();

    /**
     * Finds an active case from case id
     *
     * @param caseId the search parameter
     * @return the case found, else null
     */
    ICase findActiveCase(int caseId);

    /**
     * Finds an active case from the cpr of the concerned citizen.
     *
     * @param cpr the name of the concerned citizen
     * @return the case found, else null
     */
    ICase findActiveCase(String cpr);

    /**
     * Returns all active cases in the department
     *
     * @return all active cases in the department
     */
    List<? extends ICase> getAllActiveCases();

    /**
     * Returns all active cases of the current caseworker
     *
     * @return all active cases of the current caseworker
     */
    List<? extends ICase> getActiveCases();

    /**
     * Injects a reference to the persistence layer
     *
     * @param persistence the reference to be injected
     */
    void injectPersistence(IPersistenceFacade persistence);
    
    /**
     * Gets the current logged in case worker
     * @return The current logged in case worker
     */
    ICaseWorker getCaseWorker();
    
    /**
     * Gets all the logs
     * @return All the logs
     */
    List<? extends ILog> getAllLogs();
    
    /**
     * Gets all logs of a given type
     * @param type The log type
     * @return All the logs of a given type
     */
    List<? extends ILog> getLogsOfType(LogType type);
}
