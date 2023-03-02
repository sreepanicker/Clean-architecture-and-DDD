/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain.cif;

import com.app.domain.Event;
import java.io.Serializable;

/**
 *
 * @author sreep
 */
public class PartyCreatedEvent extends Event implements  Serializable{
    private String partyID ;
    public PartyCreatedEvent(String id){
        this.partyID = id;
        
    }
    public String eventDetails(){
        return "Party ID: "+  this.partyID + ", " + creationTime();
    }
            
    
}
