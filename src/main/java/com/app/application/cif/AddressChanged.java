/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif;

import com.app.domain.cif.AddressChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component
public class AddressChanged {
    
    @EventListener
    public void processAddressChanged(AddressChangedEvent event){
        System.out.println("event "+ event.eventDetails());
    }
    
}
