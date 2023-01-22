/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif;

import com.app.application.cif.convertor.ConvertCreatePartyObjects;
import com.app.application.cif.convertor.ConvertCreatePartyObjects.CreatePartyData;
import com.app.domain.cif.Party;
//import com.app.application.cif.convertor.CreatePartyDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreep
 */
@Service
public class CreateParty {

    @Autowired
    ConvertCreatePartyObjects convertor;

    public Optional<CreatePartyData> createParty(CreatePartyData createPartyDTO) {

 
        Optional<Party> optParty = convertor.convert(createPartyDTO);
        if (!optParty.isEmpty()) {

            //Validate the KYC
            Party party = optParty.get();
            if (party.validateKYC()) {
                 //TODO
                //Persist the data- call repository 
                // repository.save()
                // return success message 
                CreatePartyData returnDTO = new CreatePartyData(createPartyDTO.id(),"Created successfully");
               
                return Optional.of(returnDTO);
            }

        }
        return Optional.empty();
    }

}
