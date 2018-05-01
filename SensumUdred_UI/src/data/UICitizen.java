package data;

import common.Gender;
import common.ICase;
import common.ICitizen;
import common.RelationshipStatus;

/**
 * UICitizen class for representation in the GUI.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class UICitizen implements ICitizen {

    private final ICase activeCase;
    private final int cpr;
    private final String address;
    private final String name;
    private final String phoneNumber;
    private final String email;
    private final Gender gender;
    private final RelationshipStatus relStat;

    /**
     * The constructor for the UICitizen.
     *
     * @param name The citizens name
     * @param mobNumber The citizens phone number
     * @param email The citizens email
     * @param cpr The citizens cpr number
     * @param address The citizens address
     * @param relstat The citizens relationship status
     * @param gender The citizens gender
     */
    public UICitizen(int cpr, String address, String name, String mobNumber, String email, Gender gender, RelationshipStatus relstat) {
        this(cpr, address, name, mobNumber, email, gender, relstat, null);
    }

    /**
     * The constructor for the UICitizen including an instance of an ICase
     * object.
     *
     * @param name The citizens name
     * @param mobNumber The citizens phone number
     * @param email The citizens email
     * @param cpr The citizens cpr number
     * @param address The citizens address
     * @param relstat The citizens relationship status
     * @param gender The citizens gender
     * @param activeCase The active case of the citizen
     */
    public UICitizen(int cpr, String address, String name, String mobNumber, String email, Gender gender, RelationshipStatus relstat, ICase activeCase) {
        this.cpr = cpr;
        this.address = address;
        this.name = name;
        this.phoneNumber = mobNumber;
        this.email = email;
        this.gender = gender;
        this.relStat = relstat;
        this.activeCase = activeCase;
    }

    /**
     * Returns the Social security number of the citizen.
     *
     * @return the social security number
     */
    @Override
    public int getCpr() {
        return this.cpr;
    }

    /**
     * Returns the adress of the citizen.
     *
     * @return the address of the citizen
     */
    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns the gender of the Citizen.
     *
     * @return citizen's gender
     */
    @Override
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Returns the relationshipstatus of the citizen.
     *
     * @return the citizen's relationshipstatus
     */
    @Override
    public RelationshipStatus getRelationshipStatus() {
        return this.relStat;
    }

    /**
     * Returns the name of the citizen.
     *
     * @return the citizens name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the phone number of the citizen.
     *
     * @return the citizens phone number
     */
    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns the email of the citizen.
     *
     * @return the citizens emal address
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the citizens active case.
     *
     * @return the citizens active case
     */
    @Override
    public ICase getActiveCase() {
        return activeCase;
    }

}
