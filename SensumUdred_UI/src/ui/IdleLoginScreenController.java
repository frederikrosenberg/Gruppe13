/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import common.IBusinessFacade;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
 *
 * @author Sebas
 */
public class IdleLoginScreenController implements Initializable {

    @FXML
    private AnchorPane appBackground;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private GridPane loginGridPane;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ImageView EGTeamOnlineLogo;
    @FXML
    private Label forgottenPassword;
    @FXML
    private Button loginButton;
    @FXML
    private GridPane wrongUserPassGridPane;

    /**
     * The business facade used to communicate with business layer
     */
    private IBusinessFacade business;
    @FXML
    private GridPane forgottenPasswordGridPane;
    @FXML
    private GridPane loggedOutGridPane;
    @FXML
    private AnchorPane loggedoutBackground;
    @FXML
    private Button reLogin;

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
     * boolean in return. if succesful, the login screen will be hidden, and the
     * in-app screen is shown for further use. the username and password fields
     * are cleared
     *
     * else a message is shown prompting the user to try again.
     *
     * @param event button press
     */
    @FXML
    private void loginRequested(ActionEvent event) throws IOException {
        if (business.login(usernameField.getText(), passwordField.getText())) {
            wrongUserPassGridPane.setVisible(false);
            usernameField.clear();
            passwordField.clear();
            
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MainBackground.fxml"));
            appBackground.getChildren().setAll(pane);

        } else {
            wrongUserPassGridPane.setVisible(true);
            passwordField.clear();
        }
    }

    /**
     * Clicked from gui, after idle forced logout. This is done to hide the grid, informing the user, that they were logged out.
     * @param event mouse click
     */
    @FXML
    private void loginAgain(ActionEvent event) {
        loggedOutGridPane.setVisible(false);
    }

   

}
