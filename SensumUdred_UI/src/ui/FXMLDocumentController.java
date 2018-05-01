package ui;

import common.Gender;
import common.IBusinessFacade;
import common.ICase;
import common.ICitizen;
import common.ICitizenData;
import common.RelationshipStatus;
import data.UICitizen;
import data.UICitizenData;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
    private ToggleGroup understoodReference1;
    @FXML
    private Group clickable_StorageOnline;
    @FXML
    private ToggleGroup electronicStorage;
    @FXML
    private ToggleGroup understoodReference111;
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
    private ScrollPane seeSpecificCase;
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
    @FXML
    private Label noCasesFound;
    @FXML
    private Label user_JobTitle;
    @FXML
    private Label user_Name;
    @FXML
    private Label user_Email;

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

    private IBusinessFacade business;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        backgroundImage.fitHeightProperty().bind(appBackground.heightProperty());

        inappWallpaperDark.fitHeightProperty().bind(inappBackground.heightProperty());

        Calendar cal = Calendar.getInstance();
        int minute = cal.get(Calendar.MINUTE);
        String val = String.valueOf(minute);
        if (minute < 10) {
            val = "0" + String.valueOf(minute); //Makes sure that minutes < 10 are displayed as ex. 03, not just 3.
        }
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        time.setText(hour + ":" + (val));

        Calendar calen = Calendar.getInstance();
        calen.add(Calendar.DATE, 0);
        Date dato = calen.getTime();

        SimpleDateFormat format1 = new SimpleDateFormat("EEEEEEE 'd.'d MMM yyyy");
        date.setText(String.valueOf(format1.format(dato)).substring(0, 1).toUpperCase() + String.valueOf(format1.format(dato)).substring(1));

        inappScreen.setVisible(false); //Set false to force user to log in
        editCasesGridPane.setVisible(false);
        business = GUI.getInstacne().getBusiness();
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
        viewingBackdrop.setVisible(false);
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
        openNewCaseScrollPane.setVisible(false);
        viewingBackdrop.setVisible(true);
        editCasesGridPane.setVisible(true);

        try {
            casesListView.setItems(FXCollections.observableArrayList((List<ICase>) business.getActiveCases()));
            noCasesFound.setVisible(false);
        } catch (NullPointerException ex) {
            noCasesFound.setVisible(true);
        }
        casesListView.getSelectionModel().selectionModeProperty().addListener(evt -> {
            casepreview = casesListView.getSelectionModel().getSelectedItem();
            if (casepreview != null) {
                showCasePreview();
            }
        });
    }

    /**
     * Sets the case's text from the case data.
     */
    private void showCasePreview() {
        preview_Label.setText(convertCase2String(casepreview));
    }

    /**
     * Converts a given case's data to a string object, for use in the GUI
     * preview of the case.
     *
     * @param c : ICase
     * @return String of the case's data
     */
    private String convertCase2String(ICase c) {
        String rep = "";

        rep += "#" + c.getId() + "\tSagsstatus: " + c.getState() + "\t " + c.getOpeningDate() + "\n\n";

        rep += "Borger:\n";
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
        business.logOut();

        inappScreen.setVisible(false);
        loginGridPane.setVisible(true);

        usernameField.clear();
        passwordField.clear();
    }

    /**
     * Closes the open new case grid, and clears the form.
     *
     * @param event mouse click
     */
    @FXML
    private void cancelNewCase(ActionEvent event) {
        openNewCaseScrollPane.setVisible(false);
        //clearNewCaseForm();
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
        if (source_citizen.isSelected()) {
            return "Borger";
        }
        if (source_contact.isSelected()) {
            return "Pårørende";
        }
        if (source_doctor.isSelected()) {
            return "Læge";
        }
        if (source_hospital.isSelected()) {
            return "Hospital";
        }
        if (source_other.isSelected()) {
            return "Anden forvaltning";
        }
        if (source_current.isSelected()) {
            return "Igangværende indsats";
        }
        if (source_region.isSelected()) {
            return "Anden kommune";
        }
        if (source_etc.isSelected()) {
            return "Andre";
        } else {
            return "";
        }
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
     * @param event : Mouse click on button
     */
    @FXML
    private void closeCase(ActionEvent event) {
        business.closeCase(casepreview.getId());
    }

    /**
     * Cancels the preview of the given case.
     *
     * @param event : Mouse click
     */
    @FXML
    private void cancelPreviewCase(ActionEvent event) {
        seeSpecificCase.setVisible(false);
        viewingBackdrop.setVisible(false);
    }

}
