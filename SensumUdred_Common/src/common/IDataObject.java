package common;

/**
 * The interface for the data object, used for saving.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface IDataObject {

    /**
     * Gets the department that has been loaded or needs to be saved
     *
     * @return loaded/saved department
     */
    IDepartment getDepartment();

    /**
     * Gets the user manager that has been loaded or needs to be saved
     *
     * @return loaded/saved user manager
     */
    IUserManager getUserManager();
}
