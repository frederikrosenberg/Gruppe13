/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * FXML Controller class
 *
 * @author fred
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
    
    private boolean loggedIn = false;
    
    @FXML
    private AnchorPane main;
    
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
    
    private void unloadController() {
        if (currentController != null) {
            currentController.unload();
        }
    }
    
    private void showLogin() {
        loadController("fxml/LoginScreen.fxml");
    }
    
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

    @Override
    @FXML
    public void resetIdle(MouseEvent event) {
        checker.updateLastMove();
    }

    @Override
    public void logout() {
        if (loggedIn) {
            loggedIn = false;
            checker.setLogin(loggedIn);
            showLogin();
        }
    }
    
    public void login() {
        if (!loggedIn) {
            loggedIn = true;
            checker.setLogin(loggedIn);
            loadController("fxml/Menu.fxml");
        }
    }
    
    
    
}
