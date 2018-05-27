package data;

import common.CaseState;
import common.ICaseWorker;
import common.ICitizen;
import common.ICitizenData;
import java.util.Date;

/**
 * UICitizenData class for representation of the citizen in the GUI
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class UICitizenData implements ICitizenData {

    /**
     * The citizen object associated with Their case.
     */
    private final ICitizen citizen;
    
    /**
     * The state of the citizens case.
     */
    private final CaseState state;
    
    /**
     * The id of the citizens case.
     */
    private final int id;
    
    /**
     * Whether or not the citizen has given consent.
     */
    private final boolean consent;
    
    /**
     * The reason for the case and the request for treatment.
     */
    private final String reason;
    
    /**
     * The available offers for the citizen.
     */
    private final String avalibleOffers;
    
    /**
     * The source of the request.
     */
    private final String sourceOfRequest;
    
    /**
     * The case worker associated with the case.
     */
    private final ICaseWorker caseWorker;
    
    /**
     * The name of the department
     */
    private final String departmentName;
    
    /**
     * If the goal of the case got achieved
     */
    private boolean goalAchieved;
    
    /**
     * The final comments for the case
     */
    private String finalComments;
    
    /**
     * What the citizen still requires
     */
    private String citizenRequires;

    /**
     * The constructor for the UICitizenData class.
     *
     * @param citizen The citizen object 
     * @param state The state of the citizens case
     * @param id The id of the citizens case
     * @param consent Whether or not consent was given
     * @param reason The reason for the request
     * @param avalibleOffers The available offers for the citizen
     * @param sourcerOfRequest The source of the request
     * @param caseWorker The case worker object associated with the case
     * @param departmentName the name of the department
     */
    public UICitizenData(ICitizen citizen, CaseState state, int id, boolean consent, String reason, String avalibleOffers, String sourcerOfRequest, ICaseWorker caseWorker, String departmentName) {
        this.citizen = citizen;
        this.state = state;
        this.id = id;
        this.consent = consent;
        this.reason = reason;
        this.avalibleOffers = avalibleOffers;
        this.sourceOfRequest = sourcerOfRequest;
        this.caseWorker = caseWorker;
        this.departmentName = departmentName;
    }

    /**
     * Returns the citizen object.
     *
     * @return the citizen object
     */
    @Override
    public ICitizen getCitizen() {
        return this.citizen;
    }

    /**
     * Returns the status of the case.
     *
     * @return the state of the case
     */
    @Override
    public CaseState getState() {
        return this.state;
    }

    /**
     * Returns the id of the case.
     *
     * @return the id of the case
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Returns whether or not the citizen has given consent.
     *
     * @return whether consent was given
     */
    @Override
    public boolean getConsent() {
        return this.consent;
    }

    /**
     * Returns the reason for the case existing, and the citizens need for
     * further treatment.
     *
     * @return the reason for the case 
     */
    @Override
    public String getReason() {
        return this.reason;
    }

    /**
     * Returns the available offers that are relevant for the citizen.
     *
     * @return the available offers for the citizen
     */
    @Override
    public String getAvailableOffers() {
        return this.avalibleOffers;
    }

    /**
     * Returns the source of the request.
     *
     * @return the source of the request
     */
    @Override
    public String getSourceOfRequest() {
        return this.sourceOfRequest;
    }

    /**
     * Returns the case worker associated with the specific case.
     *
     * @return the caseworker object
     */
    @Override
    public ICaseWorker getCaseWorker() {
        return this.caseWorker;
    }

    /**
     * Returns the opening date of the case.
     *
     * @return a new date
     */
    @Override
    public Date getOpeningDate() {
        return new Date();
    }

    /**
     * Returns the closing date of the given case.
     *
     * @return null
     */
    @Override
    public Date getClosingDate() {
        return null;
    }
    
    /**
     * Gets the name of the department
     * @return the name of the department
     */
    @Override
    public String getDepartmentName() {
        return departmentName;
    }
    
    /**
     * If the goal got achieved
     * @return goal got achieved
     */
    @Override
    public boolean getGoalAchieved() {
        return goalAchieved;
    }
    
    /**
     * Gets what the citizen still requires
     * @return what the citizen still requires
     */
    @Override
    public String getCitizenRequires() {
        return citizenRequires;
    }

    /**
     * Gets the final comments for the case
     * @return the final comments
     */
    @Override
    public String getFinalComments() {
        return finalComments;
    }

}
