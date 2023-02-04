/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain.cif;

import com.app.domain.Event;

/**
 *
 * @author sreep
 */
public class PartyCreatedEvent extends Event{
    private String partyID ;
    public PartyCreatedEvent(String id){
        this.partyID = id;
        
    }
    public String eventDetails(){
        return "Party ID: "+  this.partyID + ", " + creationTime();
    }
            
    
}
