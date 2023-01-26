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
public class AddressChangedEvent extends Event {
    
    private final String partyID;
    
    public AddressChangedEvent(String partyID){
        super();
        this.partyID = partyID;
    }
    
    public String eventDetails(){
        return this.partyID;
    }
}
