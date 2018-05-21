/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import common.IBusinessFacade;
import common.Idleable;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Sebas
 */
public class MainBackgroundController implements Initializable, Idleable {

    @FXML
    private AnchorPane appBackground;
    @FXML
    private AnchorPane inappScreen;
    @FXML
    private Label user_JobTitle;
    @FXML
    private Label user_Name;
    @FXML
    private Label user_Email;
    @FXML
    private Label calendarMonth;
    @FXML
    private Label calendarDate;
    @FXML
    private GridPane openNewCaseGrid;
    @FXML
    private AnchorPane inappBackground;
    @FXML
    private ImageView inappWallpaperDark;
    @FXML
    private Label time;
    @FXML
    private Label date;

    /**
     * An instance of the IdleChecker class, used to count idle time.
     */
    private IdleChecker checker;

    /**
     * The business facade used to communicate with business layer
     */
    private IBusinessFacade business;

    public MainBackgroundController() {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        business = GUI.getInstance().getBusiness();

        inappWallpaperDark.fitHeightProperty().bind(inappBackground.heightProperty());

        Thread timet = new Thread(new TimeChecker(time));
        timet.setDaemon(true);
        timet.start();

        checker = new IdleChecker(5*60, this);
        Thread idle = new Thread(checker);
        idle.setDaemon(true);
        idle.start();

        Calendar cal = Calendar.getInstance();
        Calendar calen = Calendar.getInstance();
        calen.add(Calendar.DATE, 0);
        Date dato = calen.getTime();

        SimpleDateFormat format1 = new SimpleDateFormat("EEEEEEE 'd.'d MMM yyyy");
        date.setText(String.valueOf(format1.format(dato)).substring(0, 1).toUpperCase() + String.valueOf(format1.format(dato)).substring(1));

        SimpleDateFormat format2 = new SimpleDateFormat("MMM");
        calendarMonth.setText(String.valueOf(format2.format(dato)).substring(0, 1).toUpperCase() + String.valueOf(format2.format(dato)).substring(1));

        SimpleDateFormat format3 = new SimpleDateFormat("d");
        calendarDate.setText(String.valueOf(format3.format(dato)));

        user_Name.setText(business.getCaseWorker().getName());
        user_Email.setText(business.getCaseWorker().getEmail());
        user_JobTitle.setText("Sagsbehandler");

        checker.updateLastMove();
        checker.setLogin(true);
    }

    /**
     * Shows the FXML doc for creting a new case.
     *
     * @param event mouse click
     */
    @FXML
    public void OpenNewCase(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/OpenNewCase.fxml"));
        appBackground.getChildren().setAll(pane);

    }

    /**
     * Shows the FXML doc for editing the existing cases.
     *
     * @param event mouse click
     */
    @FXML
    public void EditExistingCases(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/EditExistingCases.fxml"));
        appBackground.getChildren().setAll(pane);
    }

    /**
     * Shows the FXML doc for seeing the log.
     *
     * @param event mouse click
     */
    @FXML
    public void showLog(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SeeLog.fxml"));
        appBackground.getChildren().setAll(pane);

    }

    /**
     * Calls logout on the business instance
     *
     * @param event mouse click
     */
    @FXML
    public void Logout(MouseEvent event) throws IOException {
        business.logOut(false);
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/LoginScreen.fxml"));
        appBackground.getChildren().setAll(pane);
    }

    /**
     * Resets the idle timer.
     *
     * @param event mouse moved
     */
    @FXML
    public void resetIdle(MouseEvent event) {
        checker.updateLastMove();
    }

    /**
     * Calls logout on the business instance, but with ispecifying that it was
     * due to timeout.
     */
    public void logout() throws IOException {
        business.logOut(true);
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/IdleLoginScreen.fxml"));
        appBackground.getChildren().setAll(pane);
    }

}
