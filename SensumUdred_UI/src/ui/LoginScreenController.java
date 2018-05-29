package ui;

import common.IBusinessFacade;
import common.IController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * The login controller
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class LoginScreenController implements Initializable, IController<MainController> {

    @FXML
    private AnchorPane appBackground;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private GridPane wrongUserPassGridPane;
    @FXML
    private GridPane forgottenPasswordGridPane;
    @FXML
    private GridPane loggedOutGridPane;
    
    /**
     * Reference to the main controller
     */
    private MainController mainController;

    /**
     * The business facade used to communicate with business layer
     */
    private IBusinessFacade business;
    @FXML
    private GridPane loginGridPane;
    @FXML
    private AnchorPane loadingPane;
    
    
    
    /**
     * Initialize the controller
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        business = GUI.getInstance().getBusiness();
        backgroundImage.fitHeightProperty().bind(appBackground.heightProperty());

    }

    /**
     * Shows the user a forgot password pop-up. Prompting them to take correct
     * further action.
     *
     * @param event mouse click
     */
    @FXML
    private void forgotPassword(MouseEvent event) {
        forgottenPasswordGridPane.setVisible(true);
    }

    /**
     * Called any time the user presses anywhere on the screen when the forgot
     * password has be clicked and shown.
     *
     * @param event mouse click
     */
    @FXML
    private void closeForgottenPassword(MouseEvent event) {
        forgottenPasswordGridPane.setVisible(false);
    }

    /**
     * Calls the login functionality upon the business facade, and is given a
     * boolean in return. if successful, the login screen will be hidden, and the
     * in-app screen is shown for further use. the username and password fields
     * are cleared
     *
     * else a message is shown prompting the user to try again.
     *
     * @param event button press
     */
    @FXML
    private void loginRequested(ActionEvent event) throws IOException {
        loadingPane.setVisible(true);
        if (business.login(usernameField.getText(), passwordField.getText())) {
            mainController.login();
        } else {
            wrongUserPassGridPane.setVisible(true);
            passwordField.clear();
            loadingPane.setVisible(false);
        }
    }

    /**
     * Sets the main controller
     * @param parrentController the main controller 
     */
    @Override
    public void setParrentController(MainController parrentController) {
        mainController = parrentController;
    }
    
    /**
     * Allows the controller to stop threads and clean up
     */
    @Override
    public void unload() {
        
    }
    
    /**
     * Shows the timed out pane if the user timed out
     */
    public void setTimedOut() {
        loggedOutGridPane.setVisible(true);
    }
    
    /**
     * Hides the timed out pane
     * @param event the action event
     */
    @FXML
    private void loginAgain(ActionEvent event) {
        loggedOutGridPane.setVisible(false);
    }

}
