/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import static common.CaseState.OPEN;
import common.Gender;
import common.IBusinessFacade;
import common.ICitizen;
import common.ICitizenData;
import common.RelationshipStatus;
import data.UICitizen;
import data.UICitizenData;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Sebas
 */
public class OpenNewCaseController implements Initializable{

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
    private RadioButton check_personalCare;
    @FXML
    private RadioButton check_temporaryStay;
    @FXML
    private RadioButton check_home;
    @FXML
    private RadioButton check_shoppingFood;
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
    private TextField fillable_CprField;
    @FXML
    private TextField fillable_NameField;
    @FXML
    private TextField fillable_AdressField;
    @FXML
    private TextField fillable_ZipCodeField;
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
     * The business facade used to communicate with business layer
     */
    private IBusinessFacade business;

    private static MainBackgroundController mb;

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
     * Initializes the class.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        business = GUI.getInstance().getBusiness();

        Calendar cal = Calendar.getInstance();
        Calendar calen = Calendar.getInstance();
        calen.add(Calendar.DATE, 0);
        Date dato = calen.getTime();

        SimpleDateFormat format2 = new SimpleDateFormat("MMM");
        calendarMonth.setText(String.valueOf(format2.format(dato)).substring(0, 1).toUpperCase() + String.valueOf(format2.format(dato)).substring(1));

        SimpleDateFormat format3 = new SimpleDateFormat("d");
        calendarDate.setText(String.valueOf(format3.format(dato)));

        user_Name.setText(business.getCaseWorker().getName());
        user_Email.setText(business.getCaseWorker().getEmail());
        user_JobTitle.setText("Sagsbehandler");

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
    private void createNewCase(ActionEvent event) throws IOException {
        ICitizen citizen = new UICitizen(fillable_CprField.getText(), fillable_AdressField.getText(), fillable_NameField.getText(), fillable_PhoneNumberField.getText(), fillable_EmailField.getText(), gender, relstat, business.getCaseWorker().getDepartmentName());
        ICitizenData citizenData = new UICitizenData(citizen, OPEN, 0, getConsent(), fillable_ProblemDescription.getText(), getAvailibleOffers(), getSourceOfRequest(), business.getCaseWorker(), business.getCaseWorker().getDepartmentName());
        business.openCase(citizenData);
        clearNewCaseForm();
        openNewCaseScrollPane.setVisible(false);

        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MainBackground.fxml"));
        appBackground.getChildren().setAll(pane);
        //todo
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
     * Clears the form, and reloads the main background fxml.
     *
     * @param event mouse click
     * @throws IOException file not found / null pointer
     */
    @FXML
    private void cancelNewCase(ActionEvent event) throws IOException {
        clearNewCaseForm();
        loadMainBackground();
    }

    /**
     * Loads the main background FMXL.
     *
     * @param event mouse click
     * @throws IOException file not found / null pointer
     */
    private void loadMainBackground() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MainBackground.fxml"));
        appBackground.getChildren().setAll(pane);
        //todo
    }
}
