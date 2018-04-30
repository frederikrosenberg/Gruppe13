package business.logic;

import common.IPerson;

/**
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class Person implements IPerson{

    /**
     * The name of the person
     */
    private String name;
    
    /**
     * The phone number of the person
     */
    private String phoneNumber;
    
    /**
     * The email of the person
     */
    private String email;

    /**
     * Construct a new person
     * @param name The name of the person
     * @param phoneNumber The phone number of the person
     * @param email The email of the person
     */
    public Person(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    /**
     * Gets the name of the person
     * @return The name of the person
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the phone number of the person
     * @return The phone number of the person
     */
    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Gets the email of the person
     * @return The email of the person
     */
    @Override
    public String getEmail() {
        return this.email;
    }
    
}
