/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain.cif;

/**
 *
 * @author sreep
 * This is a Domain Entity and acts like a Aggregate root
 * Provides Domain level business capability and attributes for the aggregate root
 */

public class Party {
    private String id ;
    private Type type;
    private String address;
    
    //Address should be a valid physical address
    public boolean validateKYC (){
       return address!=null && type!=null;
    }
    
    //TODO Implement the Split functionality 
    public Party[] split(){
        return new Party[2];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    public void updateAddress(String address){
        this.address = address;
    }
    
    
}


        