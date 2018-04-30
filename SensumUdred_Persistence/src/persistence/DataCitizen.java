package persistence;

import common.Gender;
import common.ICase;
import common.ICitizen;
import common.RelationshipStatus;
import java.io.Serializable;

/**
 * Data about the citizen
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class DataCitizen extends DataPerson implements ICitizen, Serializable {

    /**
     * The cpr number of the citizen
     */
    private int cpr;
    
    /**
     * The address of the citizen
     */
    private String address;
    
    /**
     * The gender of the citizen
     */
    private Gender gender;
    
    /**
     * The status of the citizens relationship
     */
    private RelationshipStatus relationshipStatus;
    
    /**
     * The constructor for the data citizen
     * @param citizen the given data
     */
    public DataCitizen(ICitizen citizen) {
        super(citizen);
        cpr = citizen.getCpr();
        address = citizen.getAddress();
        gender = citizen.getGender();
        relationshipStatus = citizen.getRelationshipStatus();
        
    }

    /**
     * The cpr number of the citizen
     * @return the cpr number
     */
    @Override
    public int getCpr() {
        return cpr;
    }
    
    /**
     * The cpr number of the citizen
     * @return the address
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * The gender of the citizen
     * @return the gender
     */
    @Override
    public Gender getGender() {
        return gender;
    }

    /**
     * The status of the citizens relationship
     * @return the relationship status
     */
    @Override
    public RelationshipStatus getRelationshipStatus() {
        return relationshipStatus;
    }

    @Override
    public ICase getActiveCase() {
        throw new UnsupportedOperationException("Not supported in GUI.");
    }
    
}
