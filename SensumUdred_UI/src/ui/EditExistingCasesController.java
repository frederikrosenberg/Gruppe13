/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import common.IBusinessFacade;
import common.ICase;
import common.Idleable;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Sebas
 */
public class EditExistingCasesController implements Initializable, Idleable {

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
    private GridPane editCasesGridPane;
    @FXML
    private ListView<ICase> casesListView;
    @FXML
    private Label noCasesFound;
    @FXML
    private AnchorPane seeSpecificCase;
    @FXML
    private Label preview_Label;

    private static MainBackgroundController mb;

    /**
     * An instance of the citizens case, for use in the case preview.
     */
    private ICase casepreview;

    /**
     * An instance of the IdleChecker class, used to count idle time.
     */
    private IdleChecker checker;

    /**
     * The business facade used to communicate with business layer
     */
    private IBusinessFacade business;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        business = GUI.getInstance().getBusiness();

        mb = new MainBackgroundController();
        checker = new IdleChecker(5*60, this);
        Thread idle = new Thread(checker);
        idle.setDaemon(true);
        idle.start();
        
        Calendar cal = Calendar.getInstance();
        Calendar calen = Calendar.getInstance();
        calen.add(Calendar.DATE, 0);
        Date dato = calen.getTime();
        
        SimpleDateFormat format2 = new SimpleDateFormat("MMM");
        calendarMonth.setText(String.valueOf(format2.format(dato)).substring(0, 1).toUpperCase() + String.valueOf(format2.format(dato)).substring(1));

        SimpleDateFormat format3 = new SimpleDateFormat("d");
        calendarDate.setText(String.valueOf(format3.format(dato)));

        casesListView.setCellFactory(value -> new ListCell<ICase>() {
            @Override
            protected void updateItem(ICase item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText("(" + item.getCitizen().getCpr() + ") \t\t " + item.getCitizen().getName() + " \t\t Status: " + item.getState());
                }
            }

        });

        casesListView.setItems(FXCollections.observableArrayList((List<ICase>) business.getActiveCases()));
        if (casesListView.getItems().isEmpty()) {
            noCasesFound.setVisible(true);
        } else {
            noCasesFound.setVisible(false);
        }
        
        user_Name.setText(business.getCaseWorker().getName());
        user_Email.setText(business.getCaseWorker().getEmail());
        user_JobTitle.setText("Sagsbehandler");

        checker.updateLastMove();
        checker.setLogin(true);
    }

    /**
     * Loads the open new case FMXL.
     * @param event mouse click
     * @throws IOException file not found / null pointer
     */
    @FXML
    private void OpenNewCase(MouseEvent event) throws IOException {
       AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/OpenNewCase.fxml"));
        appBackground.getChildren().setAll(pane);
    }

    @FXML
    private void EditExistingCases(MouseEvent event) {
    }

    /**
     * Loads the see log FMXL.
     * @param event mouse click
     * @throws IOException file not found / null pointer
     */
    @FXML
    private void showLog(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SeeLog.fxml"));
        appBackground.getChildren().setAll(pane);
    }

    /**
     * Loads the login screen FMXL.
     * @param event mouse click
     * @throws IOException file not found / null pointer
     */
    @FXML
    private void Logout(MouseEvent event) throws IOException {
        business.logOut(false);
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/LoginScreen.fxml"));
        appBackground.getChildren().setAll(pane);
    }

    /**
     * Loads the main background FMXL.
     * @param event mouse click
     * @throws IOException file not found / null pointer
     */
    @FXML
    private void closeEditCasesView(MouseEvent event) throws IOException {
        loadMainBackground();
    }

    /**
     * Sets the clicke case from the list view to the specified object of the
     * ICase type.
     *
     * @param event Mouse click
     */
    @FXML
    public void selectCaseFromListView(MouseEvent event) {
        casepreview = casesListView.getSelectionModel().getSelectedItem();
        if (casepreview != null) {
            showCasePreview();
        }
    }

    /**
     * Sets the case's text from the case data.
     */
    private void showCasePreview() {
        editCasesGridPane.setVisible(false);
        seeSpecificCase.setVisible(true);
        preview_Label.setText(convertCase2String(casepreview));
    }

    /**
     * Converts a given case's data to a string object, for use in the GUI
     * preview of the case.
     *
     * @param c the case to convert
     * @return String of the case's data
     */
    private String convertCase2String(ICase c) {
        String rep = "";

        rep += "#" + c.getId() + "\tSagsstatus: " + c.getState() + "\t " + c.getOpeningDate() + "\n\n";

        rep += "Borger:\n";
        rep += c.getCitizen().getCpr() + "\n";
        rep += c.getCitizen().getName() + "\n";
        rep += c.getCitizen().getAddress() + "\n";
        rep += c.getCitizen().getPhoneNumber() + "\n";
        rep += c.getCitizen().getEmail() + "\n";

        rep += "\n\n\n";

        rep += c.getReason() + "\n";
        rep += c.getAvailableOffers() + "\n";

        rep += "Tilhørende sagsbehandler: " + c.getCaseWorker().getName() + "(" + c.getCaseWorker().getUserId() + ")";

        return rep;
    }

    /**
     * Cancels the preview of the given case.
     *
     * @param event the mouse click
     */
    @FXML
    private void cancelPreviewCase(ActionEvent event) {
        seeSpecificCase.setVisible(false);
        editCasesGridPane.setVisible(true);
    }

    /**
     * closes the specific case, as from the preview.
     *
     * @param event mouse click on button
     */
    @FXML
    private void closeCase(ActionEvent event) throws IOException {
        business.closeCase(casepreview.getId());
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/EditExistingCases.fxml"));
        appBackground.getChildren().setAll(pane);
    }

    /**
     * Resets the idle counter.
     * @param event mouse moved
     */
    @FXML
    public void resetIdle(MouseEvent event) {
        checker.updateLastMove();
    }

    /**
     * Loads the main background FMXL.
     * @param event mouse click
     * @throws IOException file not found / null pointer
     */
    private void loadMainBackground() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MainBackground.fxml"));
        appBackground.getChildren().setAll(pane);
    }

    @Override
    public void logout() throws IOException {
        business.logOut(true);
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/IdleLoginScreen.fxml"));
        appBackground.getChildren().setAll(pane);
    }
}
