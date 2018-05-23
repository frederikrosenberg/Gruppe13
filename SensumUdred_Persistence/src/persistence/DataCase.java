package persistence;

import common.CaseState;
import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import common.IDepartment;
import java.io.Serializable;
import java.util.Date;

/**
 * The data class for a case
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class DataCase implements ICase, Serializable {

    /**
     * The citizen the case is about
     */
    private DataCitizen citizen;

    /**
     * The case worker assigned to the case
     */
    private DataCaseWorker caseWorker;
    
    /**
     * The department of the case
     */
    private String department;

    /**
     * The state of the citizen
     */
    private CaseState state;

    /**
     * The id of the case
     */
    private int id;

    /**
     * Whether or not the citizen has given consent.
     */
    private boolean consent;

    /**
     * The reason for needing help
     */
    private String reason;

    /**
     * The available offers for the citizen
     */
    private String availableOffers;

    /**
     * Where the request for help came from
     */
    private String sourceOfRequest;

    /**
     * The date the case opened
     */
    private Date openingDate;

    /**
     * The date the case closed
     */
    private Date closingDate;
    
    /**
     * If the goal for the case was achieved
     */
    private boolean goalAchieved;
    
    /**
     * The final comments for the case
     */
    private String finalComments;
    
    /**
     * If the citizen still requires help
     */
    private String citizenRequires;

    /**
     * Constructor for data case
     *
     * @param _case the given case
     * @param caseWorker the case worker
     * @param citizen the citizen
     * @param isActive whether or not the case is active or not
     */
    public DataCase(ICase _case, DataCaseWorker caseWorker, DataCitizen citizen, boolean isActive) {
        this.citizen = citizen;
        this.caseWorker = caseWorker;
        id = _case.getId();
        state = _case.getState();
        consent = _case.getConsent();
        reason = _case.getReason();
        availableOffers = _case.getAvailableOffers();
        sourceOfRequest = _case.getSourceOfRequest();
        openingDate = _case.getOpeningDate();
        closingDate = _case.getClosingDate();
        if (isActive) {
            citizen.setActiveCase(this);
        }
    }

    /**
     * The constructor for the data case
     * @param citizen the given citizen
     * @param caseWorker the given case
     * @param department the department name
     * @param state the state of the case
     * @param id the id of the case
     * @param consent if there id consent from the citizen
     * @param reason the reason for the case
     * @param availableOffers the offers for the citizen
     * @param sourceOfRequest the source of the request for help
     * @param openingDate the opening date of the case
     * @param closingDate the closing date of the case if the case is closed
     * @param goalAchieved if the goals is achieved
     * @param citizenRequires if the citizen still requires help
     * @param finalComments the final comments for the case
     */
    public DataCase(DataCitizen citizen, DataCaseWorker caseWorker, String department, CaseState state, int id, boolean consent, String reason, String availableOffers, String sourceOfRequest, Date openingDate, Date closingDate, boolean goalAchieved, String citizenRequires, String finalComments) {
        this.citizen = citizen;
        this.caseWorker = caseWorker;
        this.department = department;
        this.state = state;
        this.id = id;
        this.consent = consent;
        this.reason = reason;
        this.availableOffers = availableOffers;
        this.sourceOfRequest = sourceOfRequest;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.goalAchieved = goalAchieved;
        this.citizenRequires = citizenRequires;
        this.finalComments = finalComments;
    }
    
    

    /**
     * The citizen the case is about
     *
     * @return citizen object
     */
    @Override
    public ICitizen getCitizen() {
        return citizen;
    }

    /**
     * The state of the citizen
     *
     * @return the state
     */
    @Override
    public CaseState getState() {
        return state;
    }

    /**
     * The id of the case
     *
     * @return id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Whether the citizen has given consent or not
     *
     * @return consent
     */
    @Override
    public boolean getConsent() {
        return consent;
    }

    /**
     * The reason for the case
     *
     * @return reason for case
     */
    @Override
    public String getReason() {
        return reason;
    }

    /**
     * The available offers for the citizen
     *
     * @return offers for the citizen
     */
    @Override
    public String getAvailableOffers() {
        return availableOffers;
    }

    /**
     * The source of the request for the case
     *
     * @return source of the request for the case
     */
    @Override
    public String getSourceOfRequest() {
        return sourceOfRequest;
    }

    /**
     * Gets the case worker on the case
     *
     * @return the case worker
     */
    @Override
    public ICaseWorker getCaseWorker() {
        return caseWorker;
    }

    /**
     * Gets the opening date of the case
     *
     * @return the opening date
     */
    @Override
    public Date getOpeningDate() {
        return openingDate;
    }

    /**
     * Gets the closing date of the case
     *
     * @return the closing date
     */
    @Override
    public Date getClosingDate() {
        return closingDate;
    }

    /**
     * Gets the department of the case
     * @return the department name
     */
    @Override
    public String getDepartmentName() {
        return department;
    }
    
    /**
     * If the goal of the case is achieved
     * @return goal achieved?
     */
    @Override
    public boolean getGoalAchieved() {
        return goalAchieved;
    }

    /**
     * If the citizen still requires help
     * @return the requires
     */
    @Override
    public String getCitizenRequires() {
        return citizenRequires;
    }

    /**
     * The final comments for the case
     * @return the comments for the case
     */
    @Override
    public String getFinalComments() {
        return finalComments;
    }

}
