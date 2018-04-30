/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.List;

/**
 * The interface for the department.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface IDepartment {

    /**
     * The name of department
     *
     * @return the name
     */
    String getName();

    /**
     * The treatment area the department takes care of
     *
     * @return the treatment area
     */
    String getTreatmentArea();

    /**
     * The address of the department
     *
     * @return the address
     */
    String getAddress();

    /**
     * The email for the depart
     *
     * @return the email
     */
    String getEmail();

    /**
     * The phone number for the department
     *
     * @return the phone number
     */
    String getPhoneNumber();

    /**
     * Gets a list of inactive cases
     *
     * @return inactive cases
     */
    List<? extends ICase> getInactiveCases();

    /**
     * Get all the citizens that are being handled by the department
     *
     * @return the citizens
     */
    List<? extends ICitizen> getCitizens();

    /**
     * Gets all the active cases
     *
     * @return null
     */
    List<? extends ICase> getAllActiveCases();

    /**
     * A list of all of the case workers in the department
     *
     * @return a list of all the workers
     */
    List<? extends ICaseWorker> getCaseWorkers();
}
