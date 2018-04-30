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
    
    private int cpr;
    private String address;
    private String name;
    private int mobilNumber;
    private String email;
    private Gender gender;
    private RelationshipStatus relStat;
    
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
