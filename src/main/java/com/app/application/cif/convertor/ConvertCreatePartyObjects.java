/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif.convertor;

import com.app.domain.cif.Party;
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
    public Optional<Party> convert(CreatePartyData dTO){
        Party party = new Party();
        party.setId(dTO.id());
        party.setType(Type.valueOf(dTO.type.toUpperCase()));
        party.updateAddress(dTO.address());
        return Optional.of(party);
    }

}
