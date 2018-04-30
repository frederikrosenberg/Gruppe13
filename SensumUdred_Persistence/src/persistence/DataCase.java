package persistence;

import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import java.io.Serializable;

/**
 * The data class for a case
 * @author Frederik Rosenberg
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
     *  The state of the citizen 
     */
    private String state;
    
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
     * Constructor for data case
     * @param _case the given case
     */
    public DataCase(ICase _case) {
        citizen = new DataCitizen(_case.getCitizen());
        caseWorker = new DataCaseWorker(_case.getCaseWorker());
        id = _case.getId();
        state = _case.getState();
        consent = _case.getConsent();
        reason = _case.getReason();
        availableOffers = _case.getAvailableOffers();
        sourceOfRequest = _case.getSourceOfRequest();
    }

    /**
     * The citizen the case is about
     * @return citizen object
     */
    @Override
    public ICitizen getCitizen() {
        return citizen;
    }

    /**
     * The state of the citizen
     * @return the state
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * The id of the case
     * @return id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Whether the citizen has given consent or not
     * @return consent
     */
    @Override
    public boolean getConsent() {
        return consent;
    }

    /**
     * The reason for the case
     * @return reason for case
     */
    @Override
    public String getReason() {
        return reason;
    }

    /**
     * The available offers for the citizen
     * @return offers for the citizen
     */
    @Override
    public String getAvailableOffers() {
        return availableOffers;
    }

    /**
     * The source of the request for the case
     * @return source of the request for the case
     */
    @Override
    public String getSourceOfRequest() {
        return sourceOfRequest;
    }

    /**
     * Gets the case worker on the case
     * @return the case worker
     */
    @Override
    public ICaseWorker getCaseWorker() {
        return caseWorker;
    }
    
}
