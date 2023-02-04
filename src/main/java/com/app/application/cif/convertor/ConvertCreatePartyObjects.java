/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif.convertor;

import com.app.domain.cif.Party;
import com.app.domain.cif.PartyEntity;
import com.app.domain.cif.Type;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 * 
 * This class provide convertor class and data transfer functionality 
 */

@Component
public class ConvertCreatePartyObjects {

    //DTO for CreateParty 
    public record CreatePartyData(String id, String type, String address, String message) {

        public CreatePartyData(String id, String type, String address) {
            this(id, type, address, "");
        }
        public CreatePartyData(String id,String message){
            this(id,"","",message);
        }

    }
    
    // Convert DTO to a Party Object 
    public Optional<PartyEntity> convert(CreatePartyData dTO){
        Type type = dTO.type.equals("SINGLE")?Type.SINGLE:Type.JOINT;
        PartyEntity partyEntity =  new PartyEntity(dTO.id,type, dTO.address());
        return Optional.of(partyEntity);
    }

}
