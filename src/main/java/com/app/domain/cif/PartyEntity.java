/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain.cif;

import com.app.domain.Event;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will be renamed to Party Soon. 
 * This is a temporary implementation 
 * @author sreep
 */
public class PartyEntity {
    private String id;
    private Type type;
    private String address;
    private List<Event> partyEvents;
    
    public PartyEntity(String id, Type partyType, String address){
        this.id =id;
        this.type =partyType;
        this.address = address;
        partyEvents = new ArrayList();
    }
    
    public boolean performKYCValidation(){
        return type!=null && address !=null;
    }
    
    public void updateAddress(String address){
        this.address = address;
        partyEvents.add(new AddressChangedEvent(this.id));
    }
    public PartyEntity[] performSplit(){
        return   new PartyEntity[2]; 
    }
    public List<Event> getEvents(){
        return partyEvents;
    }
}
