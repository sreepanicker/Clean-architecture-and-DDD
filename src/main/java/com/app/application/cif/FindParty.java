/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif;

import com.app.application.cif.convertor.ConvertPartyToPartyDTO;
import com.app.application.cif.convertor.FindPartyDTO;
import com.app.application.cif.ports.ICifRepository;
import com.app.application.cif.ports.IFindParty;
import com.app.domain.cif.Party;
import com.app.domain.cif.PartyEntity;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreep This service provide the implementation of FindParty Use case
 *
 * Talks to the repository to get the details
 */
@Service
public class FindParty implements IFindParty{

    //Talks to the Repository implementation to get the Party details 
    @Autowired
    private ICifRepository cifReporty;
    
    @Autowired
    private ConvertPartyToPartyDTO cPartyDTO;
    @Override
    public Optional<FindPartyDTO> findPartyByid(String partyId) {
        Optional<PartyEntity> optParty = cifReporty.findPartyById(partyId);
        if (optParty.isPresent()) {            
            PartyEntity partyEntity = optParty.get();
            if (partyEntity.performKYCValidation()){
                FindPartyDTO partyDTO= cPartyDTO.convert(partyEntity);
                return Optional.of(partyDTO);
            }else{
                FindPartyDTO partyDTO= new FindPartyDTO();
                partyDTO.setId(partyId);
                partyDTO.setErrorMessage("Address Validation failed");
                return Optional.of(partyDTO);
            }
           
        }
        return Optional.empty();
    }
}
