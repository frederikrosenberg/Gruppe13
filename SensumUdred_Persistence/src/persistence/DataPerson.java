package persistence;

import common.IPerson;
import java.io.Serializable;

/**
 * Class for holding person data
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public abstract class DataPerson implements IPerson, Serializable {

    /**
     * Name of the person
     */
    private String name;
    
    /**
     * The mobile number of the person
     */
    private String phoneNumber;
    
    /**
     * The email of the person
     */
    private String email;
    
    /** 
     * Constructor for data person
     * @param person the interface the data is in
     */
    public DataPerson(IPerson person) {
        name = person.getName();
        phoneNumber = person.getPhoneNumber();
        email = person.getEmail();
    }
    
    /**
     * Get the name of the person
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get the mobile number of the person
     * @return 
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the email of the person;
     * @return 
     */
    @Override
    public String getEmail() {
        return email;
    }
    
}
