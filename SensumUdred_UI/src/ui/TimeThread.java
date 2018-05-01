package ui;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class TimeThread extends Thread {

    private String output;
    private Label label;

    public TimeThread(Label label) {
        this.label = label;
    }

    public void run() {
        //Runs eternally:
        while (true) {
            Date moment = new Date();
            Locale dk = new Locale("dk");

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
