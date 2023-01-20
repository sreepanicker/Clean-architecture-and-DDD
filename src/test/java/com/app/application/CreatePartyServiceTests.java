/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application;

import com.app.application.cif.CreateParty;
import com.app.application.cif.convertor.CreatePartyDTO;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author sreep
 */
@ExtendWith(MockitoExtension.class)
public class CreatePartyServiceTests {
    
       
    @InjectMocks
    CreateParty createParty;
    
    private CreatePartyDTO createPartyDTO;
    
    @BeforeEach
    void init(){
        createPartyDTO = new CreatePartyDTO();
        createPartyDTO.setId("20");
        createPartyDTO.setErrorMessage("");
    }
    
    
    @Test
    public void create_party_test1(){
      
     // when(createParty.createParty()).thenReturn(Optional.of(createPartyDTO));
        
      Optional<CreatePartyDTO> createPartyOpt =   createParty.createParty(createPartyDTO);
      CreatePartyDTO partyDTO = createPartyOpt.get();
      assert(partyDTO.getErrorMessage().equals(""));
    }
}
