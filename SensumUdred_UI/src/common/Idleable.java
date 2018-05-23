package common;

import javafx.scene.input.MouseEvent;

/**
 * Interface for a controller to be idleable
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface Idleable {
    /**
     * Resets the timer for timeout
     * @param event the mouse event
     */
    public void resetIdle(MouseEvent event);

    /**
     * Logs the user out
     * @param timeOut whether it is a time or user logout
     */
    public void logout(boolean timeOut);

}
