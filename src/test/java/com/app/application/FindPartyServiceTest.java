/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application;

import com.app.application.cif.FindParty;
import com.app.application.cif.convertor.ConvertPartyToPartyDTO;
import com.app.application.cif.convertor.PartyDTO;
import com.app.application.cif.ports.ICifRepository;
import com.app.domain.cif.Party;
import com.app.domain.cif.Type;
import java.util.Optional;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author sreep
 * This class will test the application/usecase for findParty 
 */

@ExtendWith(MockitoExtension.class)
public class FindPartyServiceTest {
    
    @InjectMocks
    FindParty findParty;
    
    @Mock
    ICifRepository cifReporty;
    
    @Mock
    ConvertPartyToPartyDTO cPartyDTO;
    
    @Test
    public void should_find_party(){
        Party party = new Party();
        party.setId("20");
        party.setType(Type.SINGLE);
        
        PartyDTO partyDTOobj = new PartyDTO();
        partyDTOobj.setId("20");
        
        when(cifReporty.findPartyById("20")).thenReturn( Optional.of(party));
        
        when(cPartyDTO.convert(party)).thenReturn(partyDTOobj);
         
        Optional<PartyDTO> partyDTO= findParty.findPartyByid("20");
      
        assert(partyDTO).get().getId().equals("20");
       // when(cPartyDTO.convert(party)).
    }
    
    @Test
    public void empty_party(){
        Party party = new Party();
        party.setId("50");
        party.setType(Type.SINGLE);
        
        when(cifReporty.findPartyById("50")).thenReturn( Optional.empty());
        Optional<PartyDTO> partyDTO= findParty.findPartyByid("50");
        
        assert(partyDTO).isEmpty();
        
    }
    
}
