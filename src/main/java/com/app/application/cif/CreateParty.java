/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif;

import com.app.application.cif.convertor.CreatePartyDTO;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreep
 */
@Service
public class CreateParty {
    public Optional<CreatePartyDTO> createParty(CreatePartyDTO createPartyDTO){
        
        //TODO
        //Convert the createPartyDTO to Party Entity
        //Validate the KYC , if success then call repository otherwise set the errormessage 
        // and send the object back to client
        return Optional.of(createPartyDTO);
    }
    
}
