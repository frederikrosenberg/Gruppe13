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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ToggleGroup clearlyChoosen;
    @FXML
    private ToggleGroup understood;
    @FXML
    private ToggleGroup informed;
    @FXML
    private ToggleGroup understoodReference1;
    @FXML
    private ToggleGroup electronicStorage;
    @FXML
    private ToggleGroup understoodReference111;
    @FXML
    private ToggleGroup relevancy;
    @FXML
    private ToggleGroup samtykke;
    @FXML
    private TextArea fillable_ProblemDescription;
    @FXML
    private Group clickable_ClarityRegarding;
    @FXML
    private Group clickable_CitizenSeeks;
    @FXML
    private Group clickable_CameFrom;
    @FXML
    private TextArea fillable_ContactPerson;
    @FXML
    private Group clickable_Understood;
    @FXML
    private Group clickable_InformedOfRights;
    @FXML
    private Group clickable_StorageOnline;
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
    private Group clickable_ConsentType;
    @FXML
    private Group clickable_ConsentFrom;
    @FXML
    private TextArea fillable_SpecialCaseDesc;

    private Gender gender;
    private RelationshipStatus relstat;
    @FXML
    private RadioButton verbal_Consent;
    @FXML
    private RadioButton written_Consent;
    @FXML
    private RadioButton check_personalCare;
    @FXML
    private RadioButton check_shoppingFood;
    @FXML
    private RadioButton check_temporaryStay;
    @FXML
    private RadioButton check_home;
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
    private ListView<ICase> casesListView;
    @FXML
    private GridPane editCasesGridPane;
    @FXML
    private ScrollPane seeSpecificCase;
    @FXML
    private TextArea fillable_ProblemDescription1;
    @FXML
    private Group clickable_ClarityRegarding1;
    @FXML
    private ToggleGroup clearlyChoosen1;
    @FXML
    private Group clickable_CitizenSeeks1;
    @FXML
    private RadioButton check_home1;
    @FXML
    private RadioButton check_personalCare1;
    @FXML
    private RadioButton check_shoppingFood1;
    @FXML
    private RadioButton check_temporaryStay1;
    @FXML
    private Group clickable_CameFrom1;
    @FXML
    private CheckBox source_citizen1;
    @FXML
    private CheckBox source_contact1;
    @FXML
    private CheckBox source_doctor1;
    @FXML
    private CheckBox source_hospital1;
    @FXML
    private CheckBox source_other1;
    @FXML
    private CheckBox source_current1;
    @FXML
    private CheckBox source_region1;
    @FXML
    private CheckBox source_etc1;
    @FXML
    private TextArea fillable_ContactPerson1;
    @FXML
    private Group clickable_Understood1;
    @FXML
    private ToggleGroup understood1;
    @FXML
    private Group clickable_InformedOfRights1;
    @FXML
    private ToggleGroup informed1;
    @FXML
    private ToggleGroup understoodReference11;
    @FXML
    private Group clickable_StorageOnline1;
    @FXML
    private ToggleGroup electronicStorage1;
    @FXML
    private ToggleGroup understoodReference1111;
    @FXML
    private TextField fillable_NameField1;
    @FXML
    private TextField fillable_AdressField1;
    @FXML
    private TextField fillable_ZipCodeField1;
    @FXML
    private TextField fillable_CprField1;
    @FXML
    private TextField fillable_PhoneNumberField1;
    @FXML
    private TextField fillable_EmailField1;
    @FXML
    private MenuButton choice_Gender1;
    @FXML
    private MenuButton choice_Relations1;
    @FXML
    private Group clickable_GuardianAndRepresentation1;
    @FXML
    private Group clickable_consent1;
    @FXML
    private ToggleGroup relevancy1;
    @FXML
    private Group clickable_ConsentType1;
    @FXML
    private RadioButton verbal_Consent1;
    @FXML
    private ToggleGroup samtykke1;
    @FXML
    private RadioButton written_Consent1;
    @FXML
    private Group clickable_ConsentFrom1;
    @FXML
    private TextArea fillable_SpecialCaseDesc1;
    @FXML
    private AnchorPane viewingBackdrop;

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
     * Injects a reference to the active instance of the businesss facade.
     *
     * @param business an instance of the IBusinessFacade
     */
    public void injectBusiness(IBusinessFacade business) {
        this.business = business;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        backgroundImage.fitHeightProperty().bind(appBackground.heightProperty());
        inappScreen.setVisible(true);
        editCasesGridPane.setVisible(false);
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
            inappScreen.setVisible(false);
            usernameField.clear();
            passwordField.clear();
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
        openNewCaseScrollPane.setVisible(true);
        editCasesGridPane.setVisible(false);

    }

    /**
     * Shows the caseworker the grid option to see and edit all cases.
     *
     * @param event mouse click
     */
    @FXML
    private void EditExistingCases(MouseEvent event) {
        editCasesGridPane.setVisible(true);
        casesListView.setItems(FXCollections.observableArrayList((List<ICase>) business.getActiveCases()));
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
    private void cancelNewCase(MouseEvent event) {
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
        gender = Gender.MALE;
    }

    /**
     * sets the gender to female
     *
     * @param event mouse click
     */
    @FXML
    private void setGender_Female(ActionEvent event) {
        gender = Gender.FEMALE;
    }

    /**
     * sets the relationship status to single
     *
     * @param event mouse click
     */
    @FXML
    private void setRelationship_Single(ActionEvent event) {
        relstat = RelationshipStatus.SINGLE;
    }

    /**
     * sets the relationship status to in a relationship
     *
     * @param event mouse click
     */
    @FXML
    private void setRelationship_InRelationship(ActionEvent event) {
        relstat = RelationshipStatus.IN_RELATIONSHIP;
    }

    /**
     * sets the relationship status to married
     *
     * @param event mouse click
     */
    @FXML
    private void setRelationship_Married(ActionEvent event) {
        relstat = RelationshipStatus.MARRIED;
    }

    @FXML
    private void closeCase(ActionEvent event) {
        business.closeCase();
    }

    @FXML
    private void cancelViewing(ActionEvent event) {
        seeSpecificCase.setVisible(false);
        viewingBackdrop.setVisible(false);
    }
}
