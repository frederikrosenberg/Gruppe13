package data;

import common.Gender;
import common.ICase;
import common.ICitizen;
import common.RelationshipStatus;

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
     * @param cpr
     * @param address
     * @param name
     * @param mobNumber
     * @param email
     * @param gender
     * @param relstat
     */
    public UICitizen(int cpr, String address, String name, String mobNumber, String email, Gender gender, RelationshipStatus relstat) {
        this(cpr, address, name, mobNumber, email, gender, relstat, null);
    }

    /**
     * The constructor for the UICitizen including an instance of an ICase
     * object.
     *
     * @param cpr
     * @param address
     * @param name
     * @param mobNumber
     * @param email
     * @param gender
     * @param relstat
     * @param activeCase
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
     * @return social security number
     */
    @Override
    public int getCpr() {
        return this.cpr;
    }

    /**
     * Returns the adress of the citizen.
     *
     * @return address : String
     */
    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns the gender of the Citizen.
     *
     * @return gender : Gender
     */
    @Override
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Returns the relationshipstatus of the citizen.
     *
     * @return relstat : Relationshipstatus
     */
    @Override
    public RelationshipStatus getRelationshipStatus() {
        return this.relStat;
    }

    /**
     * Returns the name of the citizen.
     *
     * @return name : String
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the phone number of the citizen.
     *
     * @return phoneNumber : int
     */
    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns the email of the citizen.
     *
     * @return email : String
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the citizens active case.
     *
     * @return activeCase : ICase
     */
    @Override
    public ICase getActiveCase() {
        return activeCase;
    }

}
