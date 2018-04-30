/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import common.Gender;
import common.ICase;
import common.ICitizen;
import common.RelationshipStatus;

/**
 *
 * @author Sebas
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
    
    public UICitizen(int cpr, String address, String name, String mobNumber, String email, Gender gender, RelationshipStatus relstat){
        this(cpr,address,name,mobNumber,email,gender,relstat,null);
    }
    
    public UICitizen(int cpr, String address, String name, String mobNumber, String email, Gender gender, RelationshipStatus relstat, ICase activeCase){
        this.cpr = cpr;
        this.address = address;
        this.name = name;
        this.phoneNumber = mobNumber;
        this.email = email;
        this.gender = gender;
        this.relStat = relstat;
        this.activeCase = activeCase;
    }

    @Override
    public int getCpr() {
        return this.cpr;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public RelationshipStatus getRelationshipStatus() {
        return this.relStat;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public ICase getActiveCase() {
        return activeCase;
    }
    
}
