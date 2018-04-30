/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import common.Gender;
import common.IBusinessFacade;
import common.ICitizen;
import common.ICitizenData;
import common.RelationshipStatus;
import data.UICitizen;
import data.UICitizenData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
 * FXML Controller class
 *
 * @author Sebas
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
        inappScreen.setVisible(false);
    }

    @FXML
    private void forgotPassword(MouseEvent event) {
        forgottenPasswordGridPane.setVisible(true);
    }

    @FXML
    private void closeForgottenPassword(MouseEvent event) {
        forgottenPasswordGridPane.setVisible(false);
    }

    @FXML
    private void loginRequested(ActionEvent event) {
        if (usernameField.getText().equals("Admin") && passwordField.getText().equals("Password")) {
            wrongUserPassGridPane.setVisible(false);
            inappScreen.setVisible(true);

        } else {
            wrongUserPassGridPane.setVisible(true);
        }
        passwordField.clear();
    }

    @FXML
    private void loginAgain(ActionEvent event) {
        inappScreen.setVisible(false);
        loginGridPane.setVisible(true);

        usernameField.clear();
        passwordField.clear();
    }

    @FXML
    private void OpenNewCase(MouseEvent event) {
        openNewCaseScrollPane.setVisible(true);
    }

    @FXML
    private void EditExistingCases(MouseEvent event) {
    }

    @FXML
    private void Logout(MouseEvent event) {
        inappScreen.setVisible(false);
        loginGridPane.setVisible(true);

        usernameField.clear();
        passwordField.clear();
    }

    @FXML
    private void cancelNewCase(MouseEvent event) {
        openNewCaseScrollPane.setVisible(false);
        clearNewCaseForm();
    }

    @FXML
    private void createNewCase(ActionEvent event) {
        ICitizen citizen = new UICitizen(Integer.valueOf(fillable_CprField.getText()), fillable_AdressField.getText(), fillable_NameField.getText(), fillable_PhoneNumberField.getText(), fillable_EmailField.getText(), gender, relstat);

        boolean consent = false;
        if (written_Consent.isSelected() || verbal_Consent.isSelected()) {
            consent = true;
        }

        ICitizenData citizenData = new UICitizenData(citizen, "Sagsåbning", 0, consent, fillable_ProblemDescription.getText(), getAvailibleOffers(), getSourceOfRequest(), business.getCaseWorker());
        clearNewCaseForm();
    }

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
        if(source_current.isSelected()){
            return "Igangværende indsats";
        }
        if(source_region.isSelected()){
            return "Anden kommune";
        }
        if(source_etc.isSelected()){
            return "Andre";
        }else{
            return "";
        }
    }

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

    @FXML
    private void SetGender_Male(ActionEvent event) {
        gender = Gender.MALE;
    }

    @FXML
    private void setGender_Female(ActionEvent event) {
        gender = Gender.FEMALE;
    }

    @FXML
    private void setRelationship_Single(ActionEvent event) {
        relstat = RelationshipStatus.SINGLE;
    }

    @FXML
    private void setRelationship_InRelationship(ActionEvent event) {
        relstat = RelationshipStatus.IN_RELATIONSHIP;
    }

    @FXML
    private void setRelationship_Married(ActionEvent event) {
        relstat = RelationshipStatus.MARRIED;
    }

    @FXML
    private void createNewCase(MouseEvent event) {
    }

    @FXML
    private void cancelNewCase(ActionEvent event) {
    }
}
