/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application;

import com.app.application.cif.FindParty;
import com.app.application.cif.convertor.ConvertPartyToPartyDTO;
import com.app.application.cif.convertor.FindPartyDTO;
import com.app.application.cif.ports.ICifRepository;
import com.app.domain.cif.Party;
import com.app.domain.cif.PartyEntity;
import com.app.domain.cif.Type;
import java.util.Optional;
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
    
    //Usecase in context, i.e FindParty ; requires additional mock object inside it; they are injucted using mock annotation
    @InjectMocks
    FindParty findParty;
    
    @Mock
    ICifRepository cifReporty;
    
    @Mock
    ConvertPartyToPartyDTO cPartyDTO;
    
    @Test
    public void should_find_party(){
        PartyEntity partyEntity = new PartyEntity("20", Type.SINGLE, "Rd 360 address");
        
        FindPartyDTO partyDTOobj = new FindPartyDTO();
        partyDTOobj.setId("20");
        
        when(cifReporty.findPartyById("20")).thenReturn( Optional.of(partyEntity));
        
        when(cPartyDTO.convert(partyEntity)).thenReturn(partyDTOobj);
         
        Optional<FindPartyDTO> partyDTO= findParty.findPartyByid("20");
      
        assert(partyDTO).get().getId().equals("20");
       // when(cPartyDTO.convert(party)).
    }
    
    @Test
    public void empty_party(){
        Party party = new Party();
        party.setId("50");
        party.setType(Type.SINGLE);
        
        when(cifReporty.findPartyById("50")).thenReturn( Optional.empty());
        Optional<FindPartyDTO> partyDTO= findParty.findPartyByid("50");
        
        assert(partyDTO).isEmpty();
        
    }
    
}
