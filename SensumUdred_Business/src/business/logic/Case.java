package business.logic;

import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import java.util.Date;

/**
 *
 * @author andreasmolgaard-andersen
 */
public class Case implements ICase {

    private boolean informed;
    private String state;
    private Date openingDate;
    private Date closingDate;
    private int id;
    private boolean consent;
    private String reason;
    private String availableOffers;
    private String sourceOfReqeust;
    private Citizen citizen;
    private CaseWorker caseWorker;

    public Case(String state, boolean consent, String reason, String availableOffers, String sourceOfReqeust, Citizen citizen, CaseWorker caseWorker) {
        this.state = state;
        this.consent = consent;
        this.reason = reason;
        this.availableOffers = availableOffers;
        this.sourceOfReqeust = sourceOfReqeust;
        this.citizen = citizen;
        this.caseWorker = caseWorker;
    }

    public Case(ICase c) {
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return sourceOfReqeust;
    }

    /**
     * Gets the case worker of the case
     * @return The case worker of the case
     */
    @Override
    public ICaseWorker getCaseWorker() {
        return caseWorker;
    }

    public void setInformed(boolean informed) {
        this.informed = informed;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setConsent(boolean consent) {
        this.consent = consent;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setAvailableOffers(String availableOffers) {
        this.availableOffers = availableOffers;
    }

    public void setSourceOfReqeust(String sourceOfReqeust) {
        this.sourceOfReqeust = sourceOfReqeust;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public void setCaseWorker(CaseWorker caseWorker) {
        this.caseWorker = caseWorker;
    }

}
