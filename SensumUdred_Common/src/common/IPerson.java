/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 * The Interface for the person
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public interface IPerson {

    /**
     * Get the name of the person
     *
     * @return name
     */
    String getName();

    /**
     * Get the mobile number of the person
     *
     * @return
     */
    String getPhoneNumber();

    /**
     * Get the email of the person;
     *
     * @return
     */
    String getEmail();
}
