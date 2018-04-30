/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author fsr19
 */
public interface IBusinessFacade {
    boolean login(String username, String password);
    boolean logOut();
    ICase openCase(ICitizenData citizenData);
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
