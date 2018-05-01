/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import common.ICaseWorker;
import common.ICitizen;
import common.ICitizenData;
import java.util.Date;

/**
 *
 * @author Sebas
 */
public class UICitizenData implements ICitizenData {

    private ICitizen citizen;
    private String state;
    private int id;
    private boolean consent;
    private String reason;
    private String avalibleOffers;
    private String sourceOfRequest;
    private ICaseWorker caseWorker;
    
    /**
     * The constructor for the UICitizenData class
     * @param citizen
     * @param state
     * @param id
     * @param consent
     * @param reason
     * @param avalibleOffers
     * @param sourcerOfRequest
     * @param caseWorker 
     */
    public UICitizenData(ICitizen citizen, String state, int id, boolean consent, String reason, String avalibleOffers, String sourcerOfRequest,ICaseWorker caseWorker){
        this.citizen = citizen;
        this.state = state;
        this.id = id;
        this.consent = consent;
        this.reason = reason;
        this.avalibleOffers = avalibleOffers;
        this.sourceOfRequest = sourcerOfRequest;
        this.caseWorker = caseWorker;
    }
    
    /**
     * Returns the citizen object.
     * @return citizen : ICitizen
     */
    @Override
    public ICitizen getCitizen() {
        return this.citizen;
    }

    /**
     * Returns the status of the case.
     * @return state : String
     */
    @Override
    public String getState() {
        return this.state;
    }

    /**
     * Returns the id of the case.
     * @return id : int
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Returns wether or not the citizen has given consent.
     * @return consent : boolean
     */
    @Override
    public boolean getConsent() {
        return this.consent;
    }

    /**
     * Returns the reason for the case existing, and the citizens need for further treatment.
     * @return reason : String
     */
    @Override
    public String getReason() {
        return this.reason;
    }

    /**
     * Returns the available offers that are relevant for the citizen.
     * @return avalibleOffers : String
     */
    @Override
    public String getAvailableOffers() {
        return this.avalibleOffers;
    }

    /**
     * Returns the source of the request.
     * @return sourceOfRequest : String
     */
    @Override
    public String getSourceOfRequest() {
        return this.sourceOfRequest;
    }

    /**
     * Returns the case worker associated with the specific case.
     * @return caseWorker : ICaseWorker
     */
    @Override
    public ICaseWorker getCaseWorker() {
        return this.caseWorker;
    }

    /**
     * Returns the opening date of the case.
     * @return new Date : Date
     */
    @Override
    public Date getOpeningDate() {
        return new Date();
    }

    /**
     * Returns the closing date of the given case.
     * @return null
     */
    @Override
    public Date getClosingDate() {
        return null;
    }

}
