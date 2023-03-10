/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import com.app.application.cif.convertor.ConvertCreatePartyObjects.CreatePartyData;
import com.app.application.cif.ports.ICreateParty;
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
    private ICreateParty createParty;
    
    
    @RequestMapping(value = "/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createParty(@RequestBody CreatePartyData createPartyDTO) {        
        Optional<CreatePartyData> cParty = createParty.createParty(createPartyDTO);
        if (cParty.isPresent()){
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cParty.get());
        }else{
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Unable to create Party");
        }
    }
}
