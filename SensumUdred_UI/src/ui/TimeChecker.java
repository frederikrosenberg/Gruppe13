package ui;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javafx.application.Platform;
import javafx.scene.control.Label;

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
public class TimeChecker implements Runnable {

    /**
     * the value of the time, as a string
     */
    private String output;

    /**
     * An instance of the label type
     */
    private Label label;

    /**
     * Initializes an instanse of label
     *
     * @param label the label from GUI
     */
    public TimeChecker(Label label) {
        this.label = label;
    }

    /**
     * Runs the thread, this thread sets the text of the label, to the time of
     * the DK time zone After this, the thread sleeps for 0.5 seconds and then
     * re-gets the time
     *
     */
    public void run() {
        //Runs eternally:
        while (true) {
            Date moment = new Date();
            
            DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);

            String timeout = timeFormatter.format(moment);

            output = timeout;

            //Use runLater as, a non-application thread, cannot update GUI directly.
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    label.setText(output);
                }
            });

            try {
                //sleeps for 1/2 a second each time..
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
