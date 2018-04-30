/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.List;

/**
 * The interface for the facade of the business layer, responsible for communication between GUI
 * and the business layer.
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
     * Logs the the user in, given that their information is valid.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return true if the log in was successful, else false
     */
    boolean login(String username, String password);

    /**
     * Logs the user out.
     *
     * @return true.
     */
    boolean logOut();

    /**
     * Opens a new case based on the entered data.
     *
     * @param citizenData the information needed for the case
     * @return the newly opened case
     */
    ICase openCase(ICitizenData citizenData);

    /**
     * Closes a case from a given case id
     * @param caseId The case to close
     * @return True if the case is closed
     */
    boolean closeCase(int caseId);

    /**
     * To be called when the system shuts down.
     */
    void closing();

    /**
     * Finds an active case from either cpr or case id
     *
     * @param value the search parameter
     * @param isCpr if true the value is cpr otherwise it is case id
     * @return the case found, else null
     */
    ICase findActiveCase(int value, boolean isCpr);

    /**
     * Finds an active case from the name of the concerned citizen.
     *
     * @param name the name of the concerned citizen
     * @return the case found, else null
     */
    ICase findActiveCase(String name);

    /**
     * Returns all active cases in the department.
     *
     * @return all active cases in the department
     */
    List<? extends ICase> getAllActiveCases();

    /**
     * Returns all active cases of the current caseworker.
     *
     * @return all active cases of the current caseworker
     */
    List<? extends ICase> getActiveCases();

    /**
     * Injects a reference to the persistence layer
     *
     * @param persistence the reference to be
     */
    void injectPersistence(IPersistenceFacade persistence);
    
    /**
     * Gets the current logged in case worker
     * @return The current logged in case worker
     */
    ICaseWorker getCaseWorker();
}
