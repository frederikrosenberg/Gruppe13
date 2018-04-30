package business.logic;

import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import java.util.Date;

/**
 * Contains information about a case
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class Case implements ICase {

    /**
     * If the user is informed
     */
    private boolean informed;
    
    /**
     * The state of the case
     */
    private String state;
    
    /**
     * The opening date of the case
     */
    private Date openingDate;
    
    /**
     * The closing date of the case
     */
    private Date closingDate;
    
    /**
     * The id of the case
     */
    private int id;
    
    /**
     * If the citizen has given consent
     */
    private boolean consent;
    
    /**
     * The reason of the case
     */
    private String reason;
    
    /**
     * Available offer to the case
     */
    private String availableOffers;
    
    /**
     * Source of request of the case
     */
    private String sourceOfRequest;
    
    /**
     * The citizen the case is about
     */
    private Citizen citizen;
    
    /**
     * The caseworker that works with the case
     */
    private CaseWorker caseWorker;

    /**
     * Constructs a new case
     * @param state The state of the case
     * @param consent Consent from the citizen
     * @param reason The reason for the case
     * @param availableOffers Available offers to the case
     * @param sourceOfRequest Source of request 
     * @param citizen The citizen the case is about
     * @param caseWorker The case worker of the case
     */
    public Case(String state, boolean consent, String reason, String availableOffers, String sourceOfRequest, Citizen citizen, CaseWorker caseWorker) {
        this.state = state;
        this.consent = consent;
        this.reason = reason;
        this.availableOffers = availableOffers;
        this.sourceOfRequest = sourceOfRequest;
        this.citizen = citizen;
        this.caseWorker = caseWorker;
        openingDate = new Date();
    }

    /**
     * Construct an case with already exisiting case data
     * @param c The case data to extract from
     */
    public Case(ICase c) {
        this.state = c.getState();
        this.consent = c.getConsent();
        this.reason = c.getReason();
        this.availableOffers = c.getAvailableOffers();
        this.sourceOfRequest = c.getSourceOfRequest();
        this.citizen = (Citizen) c.getCitizen();
        this.caseWorker = (CaseWorker) c.getCaseWorker();
        openingDate = c.getOpeningDate();
    }
    
    /**
     * Gets the citizen of the case's cpr number
     * @return The citizen of the case's cpr number
     */
    public int getCitizenCPR() {
        return citizen.getCpr();
    }

    /**
     * Gets the citizen of the case's name
     * @return The citizen of the case's name
     */
    public String getCitizenName() {
        return citizen.getName();
    }

    /**
     * Closes this case
     * @return True if the case is closed correct
     */
    public boolean closeCase() {
        state = "Closed";
        closingDate = new Date();
        return true;
    }

    /**
     * Gets the citizen of the case
     * @return The citizen of the case
     */
    @Override
    public ICitizen getCitizen() {
        return citizen;
    }

    /**
     * Gets the state of the case
     * @return The state of the case
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * Gets the case id
     * @return The case id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the current state of the consent
     * @return The current state of the consent
     */
    @Override
    public boolean getConsent() {
        return consent;
    }

    /**
     * Gets the reason of the case
     * @return The reason of the case
     */
    @Override
    public String getReason() {
        return reason;
    }

    /**
     * Gets the available offers
     * @return The available offers
     */
    @Override
    public String getAvailableOffers() {
        return availableOffers;
    }

    /**
     * Gets the source of request
     * @return The source of request
     */
    @Override
    public String getSourceOfRequest() {
        return sourceOfRequest;
    }

    /**
     * Gets the case worker of the case
     * @return The case worker of the case
     */
    @Override
    public ICaseWorker getCaseWorker() {
        return caseWorker;
    }

    /**
     * Sets the citizen's status to informed.
     * @param informed True if the citizen is informed
     */
    public void setInformed(boolean informed) {
        this.informed = informed;
    }

    /**
     * Sets the state of the case
     * @param state Which state the case is in
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets if the citizen has given consent
     * @param consent True if the consent is given
     */
    public void setConsent(boolean consent) {
        this.consent = consent;
    }

    /**
     * Sets the reason of the case
     * @param reason The reason of the case
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Sets the available offer of the case
     * @param availableOffers  The available offers
     */
    public void setAvailableOffers(String availableOffers) {
        this.availableOffers = availableOffers;
    }

    /**
     * Sets the source of request
     * @param sourceOfRequest The source of request
     */
    public void setSourceOfRequest(String sourceOfRequest) {
        this.sourceOfRequest = sourceOfRequest;
    }

    /**
     * Sets the citizen of the case
     * @param citizen The citizen of the case
     */
    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    /**
     * Sets the case worker of the case
     * @param caseWorker The case worker of the case
     */
    public void setCaseWorker(CaseWorker caseWorker) {
        this.caseWorker = caseWorker;
    }

    /**
     * Gets the opening date
     * @return The opening date
     */
    @Override
    public Date getOpeningDate() {
        return openingDate;
    }

    /**
     * Gets the closing date
     * @return The closing date
     */
    @Override
    public Date getClosingDate() {
        return closingDate;
    }
}
