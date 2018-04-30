/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.List;

/**
 * The Interface of the caseworker.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface ICaseWorker extends IPerson {

    /**
     * The employee id of the case worker
     *
     * @return the employee id
     */
    int getEmployeeId();

    /**
     * The user id of the user connected to this case worker
     *
     * @return the user id
     */
    String getUserId();

    /**
     * Get the active cases
     *
     * @return the cases
     */
    List<? extends ICase> getActiveCases();
}
