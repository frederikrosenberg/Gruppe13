package ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 * FXML Controller class for the GUI.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class IdleChecker implements Runnable {

    /**
     * Amount of time before user gets logged out in seconds
     */
    private int time;

    /**
     * Last time in milli seconds that the user moved the mouse.
     */
    private long lastMove;

    /**
     * A reference to the FXML Controller class, for method calls on that class.
     */
    private final FXMLDocumentController controller;

    /**
     * To check wether the user is logged in or not.
     */
    private boolean loggedIn = false;

    /**
     * Contructor for the IdleChecker.
     * @param time the sleep time in milliseconds
     * @param controller a reference to the FXML Document Controller class
     */
    public IdleChecker(int time, FXMLDocumentController controller) {
        this.time = time;
        this.controller = controller;
        lastMove = System.currentTimeMillis();
    }

    /**
     * Sets the last registered time of user move, the the current time in milliseconds
     */
    public void updateLastMove() {
        lastMove = System.currentTimeMillis();
    }

    /**
     * Sets wether the user is logged in.
     * @param loggedIn boolean referencing the users logged in status
     */
    public void setLogin(boolean loggedIn) {
        this.loggedIn = loggedIn;
        if (loggedIn) {
            synchronized (this) {
                notify();
            }
        }
    }

    /**
     *  The run method of the idle threads.
     */
    @Override
    public void run() {
        //Runs eternally:
        while (true) {
            if (!loggedIn) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(IdleChecker.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                if (System.currentTimeMillis() - lastMove > time * 1000) {
                    loggedIn = false;
                    //Use runLater as, a non-application thread, cannot update GUI directly.
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            controller.logout();
                        }
                    });
                }
            }

            try {
                //sleeps for 1/2 a second each time..
                Thread.sleep(Math.abs(time * 1000 - (System.currentTimeMillis() - lastMove)));
            } catch (InterruptedException ex) {
            }
        }
    }
}
