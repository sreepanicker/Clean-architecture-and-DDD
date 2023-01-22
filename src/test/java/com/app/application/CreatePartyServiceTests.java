/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application;

import com.app.application.cif.CreateParty;
import com.app.application.cif.convertor.ConvertCreatePartyObjects;
import com.app.application.cif.convertor.ConvertCreatePartyObjects.CreatePartyData;
import com.app.domain.cif.Party;
import com.app.domain.cif.Type;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    
    @Mock
    ConvertCreatePartyObjects convertor;
    
    private CreatePartyData createPartyDTO;
    
    @BeforeEach
    void init(){
       // createParty = new CreateParty();
        createPartyDTO = new CreatePartyData("20","join","72 Rd");
      
    }
    
    //This should return empty object
    @Test
    public void create_party_empty(){
      
      when(convertor.convert(createPartyDTO)).thenReturn(Optional.empty());
        
      Optional<CreatePartyData> createPartyOpt =   createParty.createParty(createPartyDTO);
      //CreatePartyData partyDTO = createPartyOpt.get();
      assert(createPartyOpt.isEmpty());
    }
    
    @Test
    public void create_party_success(){
        Party party = new Party();
        party.setId("20");
        party.setType(Type.JOINT);
        party.updateAddress("72 ");
        when(convertor.convert(createPartyDTO)).thenReturn(Optional.of(party));
        Optional<CreatePartyData> createPartyOpt =   createParty.createParty(createPartyDTO);
        CreatePartyData dTo = createPartyOpt.get();
        assertThat(dTo.message().contains("Created"));
    }
    
}
