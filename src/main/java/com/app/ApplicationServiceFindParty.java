/*k nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import com.app.application.cif.convertor.FindPartyDTO;
import com.app.application.cif.ports.IFindParty;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sreep
 * This is the entry point of the service. Services are exposed from this class
 * This class talks to the application core layer i.e com.app.application 
 */
@RestController
@RequestMapping(path = "/api/cif/v1/party")
public class ApplicationServiceFindParty {
    
    
    //Dependecy injection for Find Party service
    @Autowired
    private IFindParty findParty;
    
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findParty(@PathVariable String id){
        
        Optional<FindPartyDTO> partyData = findParty.findPartyByid(id);
        if ( partyData.isEmpty()){
            return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Invaild Party Id : " + id);
        }else{
            FindPartyDTO partyDTO = partyData.get();
            return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(partyDTO);
        }
      
    }
    
}
