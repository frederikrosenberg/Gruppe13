/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Date;

/**
 * The interface for a case.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface ICase {

    /**
     * The citizen the case is about
     *
     * @return citizen object
     */
    ICitizen getCitizen();

    /**
     * The state of the citizen
     *
     * @return the state
     */
    String getState();

    /**
     * The id of the case
     *
     * @return id
     */
    int getId();

    /**
     * Whether the citizen has given consent or not
     *
     * @return consent
     */
    boolean getConsent();

    /**
     * The reason for the case
     *
     * @return reason for case
     */
    String getReason();

    /**
     * The available offers for the citizen
     *
     * @return offers for the citizen
     */
    String getAvailableOffers();

    /**
     * The source of the request for the case
     *
     * @return source of the request for the case
     */
    String getSourceOfRequest();

    /**
     * Gets the case worker on the case
     *
     * @return the case worker
     */
    ICaseWorker getCaseWorker();
    
    /**
     * Gets the opening date of the case
     * @return  The opening date of the case
     */
    Date getOpeningDate();
    
    /**
     * Gets the closing date of the case
     * @return The closing date of the case
     */
    Date getClosingDate();
}
