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
    
    @Override
    public ICitizen getCitizen() {
        return this.citizen;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean getConsent() {
        return this.consent;
    }

    @Override
    public String getReason() {
        return this.reason;
    }

    @Override
    public String getAvailableOffers() {
        return this.avalibleOffers;
    }

    @Override
    public String getSourceOfRequest() {
        return this.sourceOfRequest;
    }

    @Override
    public ICaseWorker getCaseWorker() {
        return this.caseWorker;
    }

    @Override
    public Date getOpeningDate() {
        return new Date();
    }

    @Override
    public Date getClosingDate() {
        return null;
    }

}
