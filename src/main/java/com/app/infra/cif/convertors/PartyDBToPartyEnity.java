/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.infra.cif.convertors;

import com.app.domain.cif.Party;
import com.app.domain.cif.PartyEntity;
import com.app.domain.cif.Type;
import com.app.infra.cif.db.PartyDB;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component 
public class PartyDBToPartyEnity {
    
    public PartyEntity convert(PartyDB partyDB){
        PartyEntity partyEntity ;  
        
        if (partyDB.getType().equalsIgnoreCase("join")){
            partyEntity = new PartyEntity(partyDB.getId(),Type.JOINT,partyDB.getAddress());
        }else{
           partyEntity = new PartyEntity(partyDB.getId(),Type.SINGLE,partyDB.getAddress());
        }
        
        return partyEntity;
    }
    
}
