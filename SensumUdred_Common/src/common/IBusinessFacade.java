/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 * The Facade of the business layer, responsible for communication between GUI and the business layer.
 * @author fsr19
 */
public interface IBusinessFacade {
    /**
     * Logs the the user in, given that their information is valid.
     * @param username the username of the user
     * @param password the password of the user
     * @return true if the log in was successful, else false
     */
    boolean login(String username, String password);
    /**
     * Logs the user out.
     * @return true.
     */
    boolean logOut();
    /**
     * Opens a new case based on the entered data.
     * @param citizenData the information needed for the case
     * @return the newly opened case
     */
    ICase openCase(ICitizenData citizenData);
    /**
     * 
     * @return 
     */
    boolean closeCase();
    void closing();
     /**
      * Find active cases from either cpr or case id 
      * @param value the search parameter
      * @param isCpr if true the value is cpr otherwise it is case id 
      * @return the given case that is found, if no case found null is returned
      */
    ICase findActiveCase(int value, boolean isCpr);
    ICase findActiveCase(String name);
    ICase[] getAllActiveCases();
    ICase[] getActiveCases();
    void injectPersistence(IPersistenceFacade persistence);
}
