/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.infra;

import com.app.domain.cif.PartyCreatedEvent;
import com.app.domain.cif.PartyEntity;
import com.app.domain.cif.Type;
import com.app.infra.cif.CifRepository;
import com.app.infra.cif.convertors.IDbService;
import com.app.infra.cif.convertors.PartyDBToPartyEnity;
import com.app.infra.cif.db.PartyDB;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
/**
 *
 * @author sreep
 */
@ExtendWith(MockitoExtension.class)
public class CifRepositoryTests {
    
    //where to inject Mocks 
    @InjectMocks
    private CifRepository cifRepository;
    
    //Mock objects 
    
    @Mock
    private IDbService idbService;
    
    @Mock
    private PartyDBToPartyEnity partyToDBEntity;
    
    @Mock
    ApplicationEventPublisher appEvent;
    
    
    @BeforeEach
    public void init(){
        
        
    }
    
    @Test
    public void Insert_PartyEntity_success1(){
        //input for the CifRepository Insert method;
        PartyEntity partyEntity =  new PartyEntity("20", Type.SINGLE, "Rd 360 address");
        Optional<PartyEntity> optPartyEntity  = Optional.of(partyEntity);
        
        //Mocks 
        PartyDB partyDB = new PartyDB("20","SINGLE", "2020-01-20:4444", "Rd 360 address");
        Optional<PartyDB> optPartyDB = Optional.of(partyDB);
        when(partyToDBEntity.convert(optPartyEntity)).thenReturn(optPartyDB);
        
        when(idbService.insert(optPartyDB)).thenReturn(Boolean.TRUE);
        
        //call the business logic , all the mocks are ready 
        boolean status = cifRepository.save(optPartyEntity);
        assert(status);
        
    }
      @Test
    public void Insert_PartyEntity_success2(){
        //input for the CifRepository Insert method, making sure evets are zero after save;
        PartyEntity partyEntity =  new PartyEntity("20", Type.SINGLE, "Rd 360 address");
        PartyCreatedEvent event = new PartyCreatedEvent("20");
        partyEntity.addNewEvents(event);
        
        Optional<PartyEntity> optPartyEntity  = Optional.of(partyEntity);
        
        //Mocks 
        PartyDB partyDB = new PartyDB("20","SINGLE", "2020-01-20:4444", "Rd 360 address");
        Optional<PartyDB> optPartyDB = Optional.of(partyDB);
        when(partyToDBEntity.convert(optPartyEntity)).thenReturn(optPartyDB);
        
        when(idbService.insert(optPartyDB)).thenReturn(Boolean.TRUE);
        
        //Mocks - Event publishing 
        doNothing().when(appEvent).publishEvent(event);
       
        
        //call the business logic , all the mocks are ready 
        boolean status = cifRepository.save(optPartyEntity);
        int eventCount = optPartyEntity.get().getEvents().size();
        assertEquals(0,eventCount);
        
    }
    
    @Test
    //Scanorio where PartyEntity is null, it function should return false 
    public void Insert_PartyEntity_failed1(){
        
        Optional<PartyEntity> optPartyEntity  = Optional.empty();
        // if it is empty  then internal logic won't execute 
        boolean status = cifRepository.save(optPartyEntity);
        Assertions.assertEquals(false,status);              
    
    }
    
    @Test
    //Scanorio where PartyEntity is not null, but PartyDB is null , function should return false 
    public void Insert_PartyEntity_failed2(){
        PartyEntity partyEntity =  new PartyEntity("20", Type.SINGLE, "Rd 360 address");
        Optional<PartyEntity> optPartyEntity  = Optional.of(partyEntity);
        
        
        Optional<PartyDB> optPartyDB = Optional.empty();
        when(partyToDBEntity.convert(optPartyEntity)).thenReturn(optPartyDB);
        
        //call the method 
        boolean status = cifRepository.save(optPartyEntity);
        
        Assertions.assertEquals(false,status); 
        
    }

    
}
