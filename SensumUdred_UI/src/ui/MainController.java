package ui;

import common.IBusinessFacade;
import common.IController;
import common.Idleable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Main controller for the ui
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class MainController implements Initializable, Idleable {

    /**
     * An instance of the IdleChecker class, used to count idle time.
     */
    private IdleChecker checker;

    /**
     * The business facade used to communicate with business layer
     */
    private IBusinessFacade business;
    
    /**
     * Whether or not the user is logged in
     */
    private boolean loggedIn = false;
    
    @FXML
    private AnchorPane main;
    
    /**
     * The current controller showing
     */
    private IController<MainController> currentController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        business = GUI.getInstance().getBusiness();
        
        checker = new IdleChecker(5*60, this);
        Thread idle = new Thread(checker);
        idle.setDaemon(true);
        idle.start();
        showLogin();
        
        
    }
    
    /**
     * Unloads the current controller
     */
    private void unloadController() {
        if (currentController != null) {
            currentController.unload();
        }
    }
    
    /**
     * Show the login screen
     */
    private void showLogin() {
        loadController("fxml/LoginScreen.fxml");
    }
    
    /**
     * Loads a new current controller
     * @param url the URL for the .fxml document
     */
    private void loadController(String url) {
        try {
            unloadController();
            main.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(url));
            Node node = loader.load();
            currentController = loader.getController();
            currentController.setParrentController(this);
            
            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setBottomAnchor(node, 0.0);
            
            main.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Resets the idle timer, when the user moves the mouse
     * @param event the mouse event
     */
    @Override
    @FXML
    public void resetIdle(MouseEvent event) {
        checker.updateLastMove();
    }

    /**
     * Logs the current user out
     * @param timeOut if it was a timeout or not
     */
    @Override
    public void logout(boolean timeOut) {
        if (loggedIn) {
            loggedIn = false;
            checker.setLogin(loggedIn);
            showLogin();
            if (timeOut) {
                ((LoginScreenController)currentController).setTimedOut();
            }
        }
    }
    
    /**
     * Logs a user in
     */
    public void login() {
        if (!loggedIn) {
            loggedIn = true;
            checker.setLogin(loggedIn);
            loadController("fxml/Menu.fxml");
        }
    }
    
}
