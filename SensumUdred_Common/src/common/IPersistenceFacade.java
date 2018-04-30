/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

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
     * Checks whether a save is available
     *
     * @return true if there is a save available
     */
    boolean saveAvailable();

    /**
     * Save the given object to the persistence store.
     *
     * @param userManager a reference to the user manager
     * @param department a reference to the department
     * @return true if the object has been saved and false if object failed to
     * save.
     */
    boolean save(IUserManager userManager, IDepartment department);

    /**
     * Loads saved department and user manager from disk.
     *
     * @return a object containing the department and user manager, if there is
     * no saved department or user manager this returns null.
     */
    IDataObject load();
}
