package ui;

import common.Gender;
import common.IBusinessFacade;
import common.ICase;
import common.ICaseLog;
import common.ICitizen;
import common.ICitizenData;
import common.ILog;
import common.ILoginAttemptLog;
import common.LogType;
import common.RelationshipStatus;
import data.UICitizen;
import data.UICitizenData;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
public class FXMLDocumentController implements Initializable {

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
    @FXML
    private GridPane loggedOutGridPane;
    @FXML
    private AnchorPane loggedoutBackground;
    @FXML
    private Button reLogin;
    @FXML
    private GridPane forgottenPasswordGridPane;
    @FXML
    private AnchorPane inappScreen;
    @FXML
    private GridPane openNewCaseGrid;
    @FXML
    private ScrollPane openNewCaseScrollPane;
    @FXML
    private TextArea fillable_ProblemDescription;
    @FXML
    private Group clickable_ClarityRegarding;
    @FXML
    private ToggleGroup clearlyChoosen;
    @FXML
    private Group clickable_CitizenSeeks;
    @FXML
    private RadioButton check_home;
    @FXML
    private RadioButton check_personalCare;
    @FXML
    private RadioButton check_shoppingFood;
    @FXML
    private RadioButton check_temporaryStay;
    @FXML
    private Group clickable_CameFrom;
    @FXML
    private CheckBox source_citizen;
    @FXML
    private CheckBox source_contact;
    @FXML
    private CheckBox source_doctor;
    @FXML
    private CheckBox source_hospital;
    @FXML
    private CheckBox source_other;
    @FXML
    private CheckBox source_current;
    @FXML
    private CheckBox source_region;
    @FXML
    private CheckBox source_etc;
    @FXML
    private TextArea fillable_ContactPerson;
    @FXML
    private Group clickable_Understood;
    @FXML
    private ToggleGroup understood;
    @FXML
    private Group clickable_InformedOfRights;
    @FXML
    private ToggleGroup informed;
    @FXML
    private Group clickable_StorageOnline;
    @FXML
    private ToggleGroup electronicStorage;
    @FXML
    private TextField fillable_NameField;
    @FXML
    private TextField fillable_AdressField;
    @FXML
    private TextField fillable_ZipCodeField;
    @FXML
    private TextField fillable_CprField;
    @FXML
    private TextField fillable_PhoneNumberField;
    @FXML
    private TextField fillable_EmailField;
    @FXML
    private MenuButton choice_Gender;
    @FXML
    private MenuButton choice_Relations;
    @FXML
    private Group clickable_GuardianAndRepresentation;
    @FXML
    private Group clickable_consent;
    @FXML
    private ToggleGroup relevancy;
    @FXML
    private Group clickable_ConsentType;
    @FXML
    private RadioButton verbal_Consent;
    @FXML
    private ToggleGroup samtykke;
    @FXML
    private RadioButton written_Consent;
    @FXML
    private Group clickable_ConsentFrom;
    @FXML
    private TextArea fillable_SpecialCaseDesc;
    @FXML
    private GridPane editCasesGridPane;
    @FXML
    private ListView<ICase> casesListView;
    @FXML
    private AnchorPane viewingBackdrop;
    @FXML
    private AnchorPane seeSpecificCase;
    @FXML
    private Label preview_Label;
    @FXML
    private Label time;
    @FXML
    private Label date;
    @FXML
    private ImageView inappWallpaperDark;
    @FXML
    private AnchorPane inappBackground;
    @FXML
    private Label noCasesFound;
    @FXML
    private Label user_JobTitle;
    @FXML
    private Label user_Name;
    @FXML
    private Label user_Email;
    /**
     * An instance of the citizens gender, for use in creating a new case.
     */
    private Gender gender;

    /**
     * An instance of the citizens relationship status, for use in creating a
     * new case.
     */
    private RelationshipStatus relstat;

    /**
     * An instance of the citizens case, for use in the case preview.
     */
    private ICase casepreview;

    /**
     * An instance of the IdleChecker class, used to count idle time.
     */
    private IdleChecker checker;

    /**
     * An instace of the LogType class, used for showing a specific type of log.
     */
    private LogType logType;
    /**
     * An instance of the TimeChecker class, used to display current time.
     */
    private TimeChecker timethread;
    @FXML
    private Label calendarMonth;
    @FXML
    private Label calendarDate;
    @FXML
    private ListView<ILog> LogListView;
    @FXML
    private AnchorPane logPane;
    @FXML
    private Label noLogFound;
    @FXML
    private MenuButton choice_logType;

    /**
     * Clears all fields of the form that the caseworker fills to open a new
     * case.
     */
    public void clearNewCaseForm() {
        fillable_ProblemDescription.clear();
        fillable_ContactPerson.clear();
        fillable_AdressField.clear();
        fillable_ZipCodeField.clear();
        fillable_CprField.clear();
        fillable_NameField.clear();
        fillable_PhoneNumberField.clear();
        fillable_SpecialCaseDesc.clear();
        fillable_EmailField.clear();
    }

    /**
     * The business facade used to communicate with business layer
     */
    private IBusinessFacade business;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        business = GUI.getInstance().getBusiness();
        backgroundImage.fitHeightProperty().bind(appBackground.heightProperty());

        inappWallpaperDark.fitHeightProperty().bind(inappBackground.heightProperty());

        Thread timet = new Thread(new TimeChecker(time));
        timet.setDaemon(true);
        timet.start();

        checker = new IdleChecker(5 * 60, this);
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

        //calendarMonth.setText();
        inappScreen.setVisible(false); //Set false to force user to log in
        editCasesGridPane.setVisible(false);

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

    }

    /**
     * Called the application is closed
     *
     * @param event that closed the application
     */
    public void exitApplication(ActionEvent event) {
        Platform.exit();
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
    private void loginRequested(ActionEvent event) {
        if (business.login(usernameField.getText(), passwordField.getText())) {
            wrongUserPassGridPane.setVisible(false);
            inappScreen.setVisible(true);
            usernameField.clear();
            passwordField.clear();

            user_Name.setText(business.getCaseWorker().getName());
            user_Email.setText(business.getCaseWorker().getEmail());
            user_JobTitle.setText("Sagsbehandler");

            checker.updateLastMove();
            checker.setLogin(true);
        } else {
            wrongUserPassGridPane.setVisible(true);
            passwordField.clear();
        }
    }

    /**
     * Shows the login screen again, upon timeout, to prompt the user to login
     * again.
     *
     * @param event button press
     */
    @FXML
    private void loginAgain(ActionEvent event) {
        loggedOutGridPane.setVisible(false);
        inappScreen.setVisible(false);
        loginGridPane.setVisible(true);

        usernameField.clear();
        passwordField.clear();
    }

    /**
     * Shows the GUI page for creting a new case.
     *
     * @param event mouse click
     */
    @FXML
    private void OpenNewCase(MouseEvent event) {
        seeSpecificCase.setVisible(false);
        viewingBackdrop.setVisible(false);
        logPane.setVisible(false);
        editCasesGridPane.setVisible(false);
        openNewCaseScrollPane.setVisible(true);

    }

    /**
     * Shows the caseworker the grid option to see and edit all cases.
     *
     * @param event mouse click
     */
    @FXML
    private void EditExistingCases(MouseEvent event) {
        seeSpecificCase.setVisible(false);
        openNewCaseScrollPane.setVisible(false);
        logPane.setVisible(false);
        viewingBackdrop.setVisible(true);
        editCasesGridPane.setVisible(true);

        casesListView.setItems(FXCollections.observableArrayList((List<ICase>) business.getActiveCases()));
        if (casesListView.getItems().isEmpty()) {
            noCasesFound.setVisible(true);
        } else {
            noCasesFound.setVisible(false);
        }

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
     * Calls the logout functionality on the business facade. It then resets,
     * and shows the login screen.
     *
     * @param event mouse click
     */
    @FXML
    private void Logout(MouseEvent event) {
        business.logOut(false);

        inappScreen.setVisible(false);
        loginGridPane.setVisible(true);

        usernameField.clear();
        passwordField.clear();

        checker.setLogin(false);
    }

    /**
     * Closes the open new case grid, and clears the form.
     *
     * @param event mouse click
     */
    @FXML
    private void cancelNewCase(ActionEvent event) {
        openNewCaseScrollPane.setVisible(false);
        clearNewCaseForm();
    }

    /**
     * Takes the information entered in the form, and creates an instance of
     * ICitizen and an instance of ICitizenData, with all this information. Also
     * calls the openCase functionality upon the business facade. Lastly it
     * clears the open new case form.
     *
     * @param event mouse click
     */
    @FXML
    private void createNewCase(ActionEvent event) {
        ICitizen citizen = new UICitizen(Integer.valueOf(fillable_CprField.getText()), fillable_AdressField.getText(), fillable_NameField.getText(), fillable_PhoneNumberField.getText(), fillable_EmailField.getText(), gender, relstat);

        ICitizenData citizenData = new UICitizenData(citizen, "Sagsåbning", 0, getConsent(), fillable_ProblemDescription.getText(), getAvailibleOffers(), getSourceOfRequest(), business.getCaseWorker());
        business.openCase(citizenData);
        clearNewCaseForm();
        openNewCaseScrollPane.setVisible(false);
    }

    /**
     * checks to see if the consent radio buttons have been pressed, and return
     * a boolean of the result
     *
     * @return if consent was pressed
     */
    private boolean getConsent() {
        boolean consent = false;
        if (written_Consent.isSelected() || verbal_Consent.isSelected()) {
            consent = true;
        }
        return consent;
    }

    /**
     * Checks to see which source of request checkboxes were clicked, and
     * returns the titles of those boxes.
     *
     * @return the title of the source of request, for the given new case.
     */
    private String getSourceOfRequest() {
        String val = "";
        if (source_citizen.isSelected()) {
            val += "Borger, ";
        }
        if (source_contact.isSelected()) {
            val += "Pårørende, ";
        }
        if (source_doctor.isSelected()) {
            val += "Læge, ";
        }
        if (source_hospital.isSelected()) {
            val += "Hospital, ";
        }
        if (source_other.isSelected()) {
            val += "Anden forvaltning, ";
        }
        if (source_current.isSelected()) {
            val += "Igangværende indsats, ";
        }
        if (source_region.isSelected()) {
            val += "Anden kommune, ";
        }
        if (source_etc.isSelected()) {
            val += "Andre, ";
        }
        return val;
    }

    /**
     * Check to see which offers were checked off
     *
     * @return the titles of the offers marked.
     */
    private String getAvailibleOffers() {
        if (check_home.isSelected()) {
            return check_home.getText();
        }
        if (check_personalCare.isSelected()) {
            return check_personalCare.getText();
        }
        if (check_shoppingFood.isSelected()) {
            return check_shoppingFood.getText();
        }
        if (check_temporaryStay.isSelected()) {
            return check_temporaryStay.getText();
        } else {
            return "";
        }
    }

    /**
     * Sets the gender to male
     *
     * @param event mouse click
     */
    @FXML
    private void SetGender_Male(ActionEvent event) {
        choice_Gender.setText("Mand");
        gender = Gender.MALE;
    }

    /**
     * sets the gender to female
     *
     * @param event mouse click
     */
    @FXML
    private void setGender_Female(ActionEvent event) {
        choice_Gender.setText("Kvinde");
        gender = Gender.FEMALE;
    }

    /**
     * sets the relationship status to single
     *
     * @param event mouse click
     */
    @FXML
    private void setRelationship_Single(ActionEvent event) {
        choice_Relations.setText("Single");
        relstat = RelationshipStatus.SINGLE;
    }

    /**
     * sets the relationship status to in a relationship
     *
     * @param event mouse click
     */
    @FXML
    private void setRelationship_InRelationship(ActionEvent event) {
        choice_Relations.setText("I forhold");
        relstat = RelationshipStatus.IN_RELATIONSHIP;
    }

    /**
     * sets the relationship status to married
     *
     * @param event mouse click
     */
    @FXML
    private void setRelationship_Married(ActionEvent event) {
        choice_Relations.setText("Gift");
        relstat = RelationshipStatus.MARRIED;
    }

    /**
     * closes the specific case, as from the preview.
     *
     * @param event mouse click on button
     */
    @FXML
    private void closeCase(ActionEvent event) {
        business.closeCase(casepreview.getId());
        EditExistingCases(null);
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
     * Closes the edit cases view
     *
     * @param event the mouse click
     */
    @FXML
    private void closeEditCasesView(MouseEvent event) {
        editCasesGridPane.setVisible(false);
        viewingBackdrop.setVisible(false);
    }

    /**
     * Resets the idle time counter
     *
     * @param event on mouse moved
     */
    @FXML
    private void resetIdle(MouseEvent event) {
        checker.updateLastMove();
    }

    /**
     * Calls the logout method, used by the idle thread.
     */
    public void logout() {
        business.logOut(true);
    }

    /**
     * Shows the list view of the logged events
     *
     * @param event on mouse click
     */
    @FXML
    private void showLog(MouseEvent event) {
        logPane.setVisible(true);
    }

    /**
     * Closes the list view of the logged events
     *
     * @param event on mouse click
     */
    @FXML
    private void closeShowLog(MouseEvent event) {
        logPane.setVisible(false);
    }

    /**
     * Sets the requested log type to see all logs. Also sets the text for the
     * dropdown, to the given type.
     *
     * @param event mouse click, on dropdown option
     */
    @FXML
    private void setLogType_All(ActionEvent event) {
        logType = null;
        choice_logType.setText("Alle");
        getAllLogs();
    }

    /**
     * Sets the requested log type to cases viewed. Also sets the text for the
     * dropdown, to the given type.
     *
     * @param event mouse click, on dropdown option
     */
    @FXML
    private void setLogType_ViewedCases(ActionEvent event) {
        logType = LogType.CASE_VIEWED;
        choice_logType.setText("Sete sager");
        getLogOfType();
    }

    /**
     * Sets the requested log type to cases opened. Also sets the text for the
     * dropdown, to the given type.
     *
     * @param event mouse click, on dropdown option
     */
    @FXML
    private void setLogType_CaseOpened(ActionEvent event) {
        logType = LogType.OPEN_CASE;
        choice_logType.setText("Åbnede sager");
        getLogOfType();

    }

    /**
     * Sets the requested log type to cases closed. Also sets the text for the
     * dropdown, to the given type.
     *
     * @param event mouse click, on dropdown option
     */
    @FXML
    private void setLogType_ClosedCases(ActionEvent event) {
        logType = LogType.CLOSE_CASE;
        choice_logType.setText("Lukkede sager");
        getLogOfType();

    }

    /**
     * Sets the requested log type . Also sets the text for the dropdown, to the
     * given type.
     *
     * @param event mouse click, on dropdown option
     */
    @FXML
    private void setLogType_ViewedLog(ActionEvent event) {
        logType = LogType.VIEW_LOG;
        choice_logType.setText("Set log");
        getLogOfType();

    }

    /**
     * Sets the requested log type to user logins. Also sets the text for the
     * dropdown, to the given type.
     *
     * @param event mouse click, on dropdown option
     */
    @FXML
    private void setLogType_LoggedIn(ActionEvent event) {
        logType = LogType.LOGIN;
        choice_logType.setText("Log ind");
        getLogOfType();

    }

    /**
     * Sets the requested log type to user logouts. Also sets the text for the
     * dropdown, to the given type.
     *
     * @param event mouse click, on dropdown option
     */
    @FXML
    private void setLogType_LoggedOut(ActionEvent event) {
        logType = LogType.LOGOUT;
        choice_logType.setText("Log ud");
        getLogOfType();

    }

    /**
     * Sets the requested log type to user who were timeouted Also sets the text
     * for the dropdown, to the given type.
     *
     * @param event mouse click, on dropdown option
     */
    @FXML
    private void setLogType_IdleLogOut(ActionEvent event) {
        logType = LogType.TIMEOUT;
        choice_logType.setText("Inaktivitets Log ud");
        getLogOfType();

    }

    /**
     * Sets the requested log type to login attempts. Also sets the text for the
     * dropdown, to the given type.
     *
     * @param event mouse click, on dropdown option
     */
    @FXML
    private void setLogType_AttemptedLogIn(ActionEvent event) {
        logType = LogType.ATTEMPT_LOGIN;
        choice_logType.setText("Log ind forsøg");
        getLogOfType();

    }

    /**
     * First the list view is formatted, then it Gets logs of the specified type
     * (logType). This is specified for each dropdown menu option click. Also
     * sets the listView's items.
     */
    private void getLogOfType() {
        showStandardLogs();

        LogListView.setItems(FXCollections.observableArrayList((List<ILog>) business.getLogsOfType(logType)));
        if (LogListView.getItems().isEmpty()) {
            noLogFound.setVisible(true);
        } else {
            noLogFound.setVisible(false);
        }
    }

    /**
     * Formats the listview's cells, then gets all the log entries.
     */
    private void getAllLogs() {
        showStandardLogs();
        LogListView.setItems(FXCollections.observableArrayList((List<ILog>) business.getAllLogs()));
        if (LogListView.getItems().isEmpty()) {
            noLogFound.setVisible(true);
        } else {
            noLogFound.setVisible(false);
        }
    }

    public void showStandardLogs() {
        LogListView.setCellFactory(value -> new ListCell<ILog>() {
            @Override
            protected void updateItem(ILog item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText("User: " + item.getUserId() + "\t " + item.getLogType().name() + "\t Date: " + item.getDate());
                }
            }
        });
    }
}
