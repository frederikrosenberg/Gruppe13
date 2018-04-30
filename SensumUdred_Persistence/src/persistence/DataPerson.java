package persistence;

import common.IPerson;
import java.io.Serializable;

/**
 * Class for holding person data
 * @author Frederik Rosenberg
 */
public abstract class DataPerson implements IPerson, Serializable {

    /**
     * Name of the person
     */
    private String name;
    
    /**
     * The mobile number of the person
     */
    private int mobileNumber;
    
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
        mobileNumber = person.getMobileNumber();
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
    public int getMobileNumber() {
        return mobileNumber;
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
