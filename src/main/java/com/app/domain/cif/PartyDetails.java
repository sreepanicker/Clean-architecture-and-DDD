/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain.cif;

/**
 *
 * @author sreep
 */
public class PartyDetails {
    private String firstName;
    private String lastName;
    public PartyDetails(String firstName ,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFullName(){
        return firstName + "," +lastName;
    }
    
}
