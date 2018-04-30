/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import common.Gender;
import common.ICitizen;
import common.RelationshipStatus;

/**
 *
 * @author Sebas
 */
public class UICitizen implements ICitizen {
    
    private final int cpr;
    private final String address;
    private final String name;
    private final int mobilNumber;
    private final String email;
    private final Gender gender;
    private final RelationshipStatus relStat;
    
    public UICitizen(int cpr, String address, String name, int mobNumber, String email, Gender gender, RelationshipStatus relstat){
        this.cpr = cpr;
        this.address = address;
        this.name = name;
        this.mobilNumber = mobNumber;
        this.email = email;
        this.gender = gender;
        this.relStat = relstat;
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
    public int getMobileNumber() {
        return this.mobilNumber;
    }

    @Override
    public String getEmail() {
        return this.email;
    }
    
}
