/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain;

import com.app.domain.cif.PartyEntity;
import com.app.domain.cif.PartyService;
import com.app.domain.cif.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author sreep
 */
@ExtendWith(MockitoExtension.class)
public class PartyServiceTests {

    private PartyEntity partyEntityPri;
    private PartyEntity partyEntitySec;
    
    
    @InjectMocks
    private PartyService partyService;

    @BeforeEach
    public void init() {
        partyEntityPri = new PartyEntity("20", Type.SINGLE, "Rd 360 address");
        partyEntitySec = new PartyEntity("21", Type.SINGLE, "Rd 400 address");
    }

    @Test
    public void merge_party_success1() {
        
        
       PartyEntity partyEntity = partyService.merge(partyEntityPri, partyEntitySec);
       Assertions.assertEquals(null,partyEntity);

    }

}
