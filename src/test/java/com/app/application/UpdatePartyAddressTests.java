/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application;

import com.app.application.cif.UpdatePartyAddress;
import com.app.application.cif.convertor.UpdatePartyAddressConvertor.UpdateAddressDTO;
import com.app.application.cif.ports.ICifRepository;
import com.app.domain.cif.PartyEntity;
import com.app.domain.cif.Type;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author sreep
 */
@ExtendWith(MockitoExtension.class)
public class UpdatePartyAddressTests {
    
    @InjectMocks
    UpdatePartyAddress updateAddress;
    
    @Mock
    ICifRepository cifRepository;
    
    @BeforeEach
    public void init(){
        
    }
    
    @Test
    //Validat the PartyEnity address is set correctly, and  the output must be success and party Event should be 1
    public void update_address_success1(){
        
        UpdateAddressDTO addressDTO = new UpdateAddressDTO("30","9700 Adresss");
        Optional<UpdateAddressDTO> optAddress = Optional.of(addressDTO);
         
        //PartyEnity 
        PartyEntity partyEntity = new PartyEntity("30", Type.SINGLE, " 36 Adresss");
  
        
        // Mocking the cif Repository call
        Optional<PartyEntity> optPartyEnity = Optional.of(partyEntity);
        when(cifRepository.findPartyById(addressDTO.id())).thenReturn(optPartyEnity);
        when(cifRepository.save(optPartyEnity)).thenReturn(Boolean.TRUE);
        
        // Now call the update address business logic , it should set the PartyEnity address to 9700 Address 
        Optional<UpdateAddressDTO> updateaddress = updateAddress.updateAddress(optAddress);
        System.out.println(updateaddress.get().message());
        assert(updateaddress.get().message().contains("Success"));
        Assertions.assertEquals(1,partyEntity.getEvents().size());
    }
    
     @Test
    //Validat the PartyEnity address is set correctly, and  the output must be failed because address is null
     public void update_address_failed1(){
        
        UpdateAddressDTO addressDTO = new UpdateAddressDTO("30",null);
        Optional<UpdateAddressDTO> optAddress = Optional.of(addressDTO);
         
        //PartyEnity 
        PartyEntity partyEntity = new PartyEntity("30", Type.SINGLE, " 36 Adresss");
  
        
        // Mocking the cif Repository call
        Optional<PartyEntity> optPartyEnity = Optional.of(partyEntity);
        when(cifRepository.findPartyById(addressDTO.id())).thenReturn(optPartyEnity);
      
        // Now call the update address business logic , it should set the PartyEnity address to 9700 Address 
        Optional<UpdateAddressDTO> updateaddress = updateAddress.updateAddress(optAddress);
        System.out.println(updateaddress.get().message());
        assert(updateaddress.get().message().contains("Failed"));
        //Assertions.assertEquals(1,partyEntity.getEvents().size());
    }
    
     @Test
    //Validat the PartyEnity address is set correctly, and  the output must be failed because 
    // call to repository failed 
    public void update_address_failed2(){
        
        UpdateAddressDTO addressDTO = new UpdateAddressDTO("30","9700 Adresss");
        Optional<UpdateAddressDTO> optAddress = Optional.of(addressDTO);
         
        //PartyEnity 
        PartyEntity partyEntity = new PartyEntity("30", Type.SINGLE, " 36 Adresss");
  
        
        // Mocking the cif Repository call
        Optional<PartyEntity> optPartyEnity = Optional.of(partyEntity);
        when(cifRepository.findPartyById(addressDTO.id())).thenReturn(optPartyEnity);
        when(cifRepository.save(optPartyEnity)).thenReturn(Boolean.FALSE);
        
        // Now call the update address business logic , it should set the PartyEnity address to 9700 Address 
        Optional<UpdateAddressDTO> updateaddress = updateAddress.updateAddress(optAddress);
        System.out.println(updateaddress.get().message());
        assert(updateaddress.get().message().contains("Failed"));
        //Assertions.assertEquals(1,partyEntity.getEvents().size());
    }
    
     @Test
    //No Party Entity returned 
    // call to repository failed 
    public void update_address_failed3(){
        
        UpdateAddressDTO addressDTO = new UpdateAddressDTO("30","9700 Adresss");
        Optional<UpdateAddressDTO> optAddress = Optional.of(addressDTO);
         
        //NO Party Entity returned
        
        // Mocking the cif Repository call
        Optional<PartyEntity> optPartyEnity = Optional.empty();
        when(cifRepository.findPartyById(addressDTO.id())).thenReturn(optPartyEnity);
              
        // Now call the update address business logic , it should set the PartyEnity address to 9700 Address 
        Optional<UpdateAddressDTO> updateaddress = updateAddress.updateAddress(optAddress);
        System.out.println(updateaddress.get().message());
        assert(updateaddress.get().message().contains("Failed"));
        //Assertions.assertEquals(1,partyEntity.getEvents().size());
    }
    
}
