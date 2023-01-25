/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain.cif;

/**
 * This class will be renamed to Party Soon. 
 * This is a temporary implementation 
 * @author sreep
 */
public class PartyEntity {
    private String id;
    private Type type;
    private String address;
    
    public PartyEntity(String id, Type partyType, String address){
        this.id =id;
        this.type =partyType;
        this.address = address;
    }
    
    public boolean performKYCValidation(){
        return type!=null && address !=null;
    }
    
    public void updateAddress(String address){
        this.address = address;
    }
    public PartyEntity[] performSplit(){
        return   new PartyEntity[2]; 
    }
}
