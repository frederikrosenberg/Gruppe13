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
     * The active for the citizen, can be null
     */
    private DataCase activeCase;
    
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
        activeCase = null;
    }
    
    /**
     * Sets the active case for the citizen
     * @param _case the given case
     */
    public void setActiveCase(DataCase _case) {
        activeCase = _case;
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

    /**
     * Get the active case for the citizen.
     * Can be null if the citizen does not have a active case
     * @return the active case
     */
    @Override
    public ICase getActiveCase() {
        return activeCase;
    }
    
}
