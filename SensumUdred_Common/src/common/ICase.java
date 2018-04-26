/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author fsr19
 */
public interface ICase {
    ICitizen getCitizen();
    String getState();
    int getId();
    boolean getConsent();
    String getReason();
    String getAvailableOffers();
    String getSourceOfRequest();
    ICaseWorker getCaseWorker();
}
