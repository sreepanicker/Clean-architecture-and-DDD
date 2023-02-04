/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application;

import com.app.application.cif.CreateParty;
import com.app.application.cif.convertor.ConvertCreatePartyObjects;
import com.app.application.cif.convertor.ConvertCreatePartyObjects.CreatePartyData;
import com.app.application.cif.ports.ICifRepository;
import com.app.domain.cif.PartyEntity;
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
    
    @Mock
    ICifRepository ciftRepo;
    
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
        PartyEntity partyEntity =  new PartyEntity("20", Type.SINGLE, "Rd 360 address");
        Optional<PartyEntity> opt = Optional.of(partyEntity);
        //Mocking the convertor 
        when(convertor.convert(createPartyDTO)).thenReturn(Optional.of(partyEntity));
        //Mocking the repository 
        when(ciftRepo.save(opt)).thenReturn(true);
        
        Optional<CreatePartyData> createPartyOpt =   createParty.createParty(createPartyDTO);
        CreatePartyData dTo = createPartyOpt.get();
        assert(dTo.message().contains("Created"));
    }
    
    @Test
    public void create_party_failed(){
        PartyEntity partyEntity =  new PartyEntity("20", Type.SINGLE, "Rd 360 address");
        Optional<PartyEntity> opt = Optional.of(partyEntity);
        //Mocking the convertor 
        when(convertor.convert(createPartyDTO)).thenReturn(Optional.of(partyEntity));
        
         //Mocking the repository 
        when(ciftRepo.save(opt)).thenReturn(false);
        
        Optional<CreatePartyData> createPartyOpt =   createParty.createParty(createPartyDTO);
        CreatePartyData dTo = createPartyOpt.get();
        assert(dTo.message().contains("Unable"));
        
        
        
    }
    
}
