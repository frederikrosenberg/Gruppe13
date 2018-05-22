package business.logic;

import common.Gender;
import common.ICase;
import common.ICitizen;
import common.RelationshipStatus;

/**
 * Contains information about a citizen
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class Citizen extends Person implements ICitizen {

    /**
     * The CPR number of the citizen
     */
    private int cpr;

    /**
     * The address of the citizen
     */
    private String address;

    /**
     * The relationship status of the citizen
     */
    private RelationshipStatus relationshipStatus;

    /**
     * The citizens gender
     */
    private Gender gender;

    /**
     * The current active case of the citizen
     */
    private Case activeCase;

    /**
     * Construct a new citizen
     *
     * @param name The citizens name
     * @param mobileNumber The citizens phone number
     * @param email The citizens email
     * @param cpr The citizens cpr number
     * @param address The citizens address
     * @param relationshipStatus The citizens relationship status
     * @param gender The citizens gender
     */
    public Citizen(String name, String mobileNumber, String email, int cpr, String address, RelationshipStatus relationshipStatus, Gender gender, String departmentName) {
        super(name, mobileNumber, email, departmentName);
        this.cpr = cpr;
        this.address = address;
        this.relationshipStatus = relationshipStatus;
        this.gender = gender;
    }

    /**
     * Construct a citizen from an existing citizen
     *
     * @param citizen The existing citizen to extract data from
     */
    public Citizen(ICitizen citizen) {
        super(citizen.getName(), citizen.getPhoneNumber(), citizen.getEmail(), citizen.getDepartmentName());
        this.cpr = citizen.getCpr();
        this.address = citizen.getAddress();
        this.relationshipStatus = citizen.getRelationshipStatus();
        this.gender = citizen.getGender();
    }

    /**
     * Gets the citizens cpr number
     *
     * @return the citizens cpr number
     */
    @Override
    public int getCpr() {
        return cpr;
    }

    /**
     * Removes the citizens active case
     */
    public void removeActiveCase() {
        activeCase = null;
    }

    /**
     * Sets the active case of the citizen
     *
     * @param c The case to set
     */
    public void setActiveCase(Case c) {
        activeCase = c;
    }

    /**
     * Gets the citizens gender
     *
     * @return The citizens gender
     */
    @Override
    public Gender getGender() {
        return gender;
    }

    /**
     * Gets the citizens relationship status
     *
     * @return The citizens relationship status
     */
    @Override
    public RelationshipStatus getRelationshipStatus() {
        return relationshipStatus;
    }

    /**
     * Gets the citizens address
     *
     * @return The citizens address
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Gets the active case
     *
     * @return The active case
     */
    @Override
    public ICase getActiveCase() {
        return activeCase;
    }
}
