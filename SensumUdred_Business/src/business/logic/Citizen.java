package business.logic;

import common.Gender;
import common.ICitizen;
import common.RelationshipStatus;

/**
 *
 * @author andreasmolgaard-andersen
 */
public class Citizen extends Person implements ICitizen {

    private int cpr;
    private String address;
    private RelationshipStatus relationshipStatus;
    private Gender gender;
    

    public Citizen(String name, String mobileNumber, String email, int cpr, String address, RelationshipStatus relationshipStatus, Gender gender) {
        super(name, mobileNumber, email);
        this.cpr = cpr;
        this.address = address;
        this.relationshipStatus = relationshipStatus;
        this.gender = gender;
    }
    
    public Citizen(ICitizen citizen) {
        super(citizen.getName(), citizen.getPhoneNumber(), citizen.getEmail());
        this.cpr = citizen.getCpr();
        this.address = citizen.getAddress();
        this.relationshipStatus = citizen.getRelationshipStatus();
        this.gender = citizen.getGender();     
    }
    
    @Override
    public int getCpr() {
        return cpr;
    }
    
    public void removeActiveCase() {
        
    }
    
    @Override
    public Gender getGender() {
        return gender;
    }
    
    @Override
    public RelationshipStatus getRelationshipStatus() {
        return relationshipStatus;
    }

    @Override
   public String getAddress() {
       return address;
   }

    
}
