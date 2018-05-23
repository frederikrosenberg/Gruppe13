/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import common.IController;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author fred
 */
public class BackgroundController implements Initializable, IController<MenuController> {

    private Thread timerThread;
    
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

    @Override
    public void setParrentController(MenuController parrentController) {
    }

    @Override
    public void unload() {
        timer.stop();
        timerThread.interrupt();
    }
    
}
