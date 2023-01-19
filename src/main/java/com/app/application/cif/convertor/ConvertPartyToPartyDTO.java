/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif.convertor;

import com.app.domain.cif.Party;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component
public class ConvertPartyToPartyDTO {
    
    public FindPartyDTO convert(Party party){
        FindPartyDTO partyDTO = new FindPartyDTO();
        partyDTO.setId(party.getId());
        partyDTO.setType(party.getType().name());
        partyDTO.setErrorMessage("");
        return partyDTO;
    }
}
