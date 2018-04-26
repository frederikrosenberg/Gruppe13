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
    

    public Citizen() {
        
    }
    
    public Citizen(ICitizen citizen) {
        
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
