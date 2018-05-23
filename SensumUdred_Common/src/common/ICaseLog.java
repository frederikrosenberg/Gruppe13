package common;

/**
 * The interface for case log
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface ICaseLog extends ILog {
    /**
     * Gets the case id
     * @return The case id
     */
    int getCaseId();
    
    /**
     * Gets the department name
     * @return The department name
     */
    String getDepartmentName();
}
