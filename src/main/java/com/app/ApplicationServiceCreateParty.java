/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import com.app.application.cif.CreateParty;
import com.app.application.cif.convertor.CreatePartyDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sreep
 */
@RestController
@RequestMapping(path = "/api/cif/v1/party")
public class ApplicationServiceCreateParty {
    
    @Autowired
    private CreateParty createParty;
    
    
    @RequestMapping(value = "/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createParty(@RequestBody CreatePartyDTO createPartyDTO) {        
        Optional<CreatePartyDTO> cParty = createParty.createParty(createPartyDTO);
        if (cParty.isPresent()){
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cParty.get());
        }else{
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Unable to create Party");
        }
    }
}
