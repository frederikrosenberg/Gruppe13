package common;

/**
 * The interface for the facade of the GUI.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface IUI {

    /**
     * Injects a reference to the business facade into the called object.
     *
     * @param business the reference to the business facade
     */
    void injectBusiness(IBusinessFacade business);

    /**
     * Starts the application.
     *
     * @param args commandline Arguments
     */
    void startApplication(String[] args);
}
