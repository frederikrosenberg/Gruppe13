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

    private long lastMove;

    private final FXMLDocumentController controller;

    private boolean loggedIn = false;

    public IdleChecker(int time, FXMLDocumentController controller) {
        this.time = time;
        this.controller = controller;
        lastMove = System.currentTimeMillis();
    }

    public void updateLastMove() {
        lastMove = System.currentTimeMillis();
    }

    public void setLogin(boolean loggedIn) {
        this.loggedIn = loggedIn;
        if (loggedIn) {
            synchronized (this) {
                notify();
            }
        }
    }

    /**
     * Runs the thread, this thread sets the text of the label, to the time of
     * the DK time zone After this, the thread sleeps for 0.5 seconds and then
     * re-gets the time
     *
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
