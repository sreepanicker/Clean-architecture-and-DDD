/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif;

import com.app.domain.cif.AddressChangedEvent;
import com.app.domain.cif.PartyCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component
public class CifEvents {
    
    @EventListener
    public void processAddressChanged(AddressChangedEvent event){
        System.out.println("Event Processed, Address Changed: "+ event.eventDetails());
    }
    
    @EventListener
    public void processPartyCreated(PartyCreatedEvent event){
        System.out.println("Event Processed, Party Created: " + event.eventDetails());
    }
   
}
