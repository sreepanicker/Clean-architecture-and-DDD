/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.infra.cif.convertors;

import com.app.domain.cif.Party;
import com.app.domain.cif.Type;
import com.app.infra.cif.db.PartyDB;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component 
public class PartyDBToPartyEnity {
    
    public Party convert(PartyDB partyDB){
        Party party = new Party();
        party.setId(partyDB.getId());
        if (partyDB.getType().equalsIgnoreCase("join")){
            party.setType(Type.JOINT);
        }else{
           party.setType(Type.SINGLE); 
        }
        party.updateAddress(partyDB.getAddress());
        return party;
    }
    
}
