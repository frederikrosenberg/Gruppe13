package ui;

import common.IController;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Background controller
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class BackgroundController implements Initializable, IController<MenuController> {

    /**
     * The thread for the timer checker
     */
    private Thread timerThread;
    
    /**
     * Updates the timer on the background
     */
    private TimeChecker timer;
    
    @FXML
    private Label time;
    @FXML
    private Label date;
    @FXML
    private ImageView inappWallpaperDark;
    @FXML
    private AnchorPane root;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timer = new TimeChecker(time);
        timerThread = new Thread(timer);
        timerThread.setDaemon(true);
        timerThread.start();
        
        inappWallpaperDark.fitHeightProperty().bind(root.heightProperty());
        
        Calendar calen = Calendar.getInstance();
        calen.add(Calendar.DATE, 0);
        Date dato = calen.getTime();

        SimpleDateFormat format1 = new SimpleDateFormat("EEEEEEE 'd.'d MMM yyyy");
        date.setText(String.valueOf(format1.format(dato)).substring(0, 1).toUpperCase() + String.valueOf(format1.format(dato)).substring(1));
    }    

    /**
     * Sets the menu controller
     * @param parrentController the menu controller
     */
    @Override
    public void setParrentController(MenuController parrentController) {
    }

    /**
     * Allows the controller to stop threads and clean up
     */
    @Override
    public void unload() {
        timer.stop();
        timerThread.interrupt();
    }
    
}
