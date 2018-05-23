package common;


/**
 * Interface for a controller that needs contract to a parent controller
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 * @param <T> What controller it is
 */
public interface IController<T> {
    /**
     * Sets the parents controller
     * @param parentController the parent controller
     */
    void setParrentController(T parentController);
    
    /**
     * Allows the controller to stop threads and clean up
     */
    void unload();
}
