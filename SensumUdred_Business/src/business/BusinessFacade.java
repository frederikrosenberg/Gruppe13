/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.common.ILogicFacade;
import business.common.ISecurityFacade;
import business.logic.LogicFacade;
import business.security.SecurityFacade;
import common.IBusinessFacade;
import common.ICase;
import common.ICaseWorker;
import common.ICitizenData;
import common.IDataObject;
import common.IPersistenceFacade;
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
    private IPersistenceFacade persistence;

    /**
     * Constructor for the BusinessFacade
     */
    public BusinessFacade() {

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
            return false;
        }
        if (security.hasAccess(Role.CASEWORKER)) {
            logic.setCaseWorker(id);
        }

        return true;
    }

    /**
     * Logs the user out
     *
     * @return true.
     */
    @Override
    public boolean logOut() {
        if (security.hasAccess(Role.CASEWORKER)) {
            logic.removeCaseWorker();
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
            return logic.openCase(citizenData);
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
            return logic.closeCase(caseId);
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
            return logic.findActiveCase(value, isCpr);
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
            return logic.findActiveCase(name);
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
     * Loads in the saved data if any is available
     */
    private void load() {
        if (persistence.saveAvailable()) {
            IDataObject data = persistence.load();
            logic = new LogicFacade(data.getDepartment());
            security = new SecurityFacade(data.getUserManager());

        } else {
            logic = new LogicFacade();
            security = new SecurityFacade();
        }
    }

    /**
     * Saves the data
     *
     * @return true if the data is saved
     */
    private boolean save() {
        return persistence.save(security.getUserManager(), logic.getDepartment());
    }

}
