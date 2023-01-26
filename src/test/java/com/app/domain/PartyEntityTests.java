/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain;

import com.app.domain.cif.PartyEntity;
import com.app.domain.cif.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sreep
 */
public class PartyEntityTests {

    private PartyEntity partyEntity;

    @BeforeEach
    public void init() {
        partyEntity = new PartyEntity("20", Type.SINGLE, "Rd 360 address");

    }

    @Test
    public void Validate_performKYCValidation_success() {

        Assertions.assertEquals(true, partyEntity.performKYCValidation());

    }

    @Test
    public void Validate_getEvents_success() {
        //Domain events should be zero before address updates;
        Assertions.assertEquals(0, partyEntity.getEvents().size());
    }
    @Test
    public void Validate_updateAddress_success() {
        //Domain events should be 1 after the address update 
        partyEntity.updateAddress("New world rd 72");
        Assertions.assertEquals(1, partyEntity.getEvents().size());
    }

    @Test
    public void Validate_performSplit_success() {
        Assertions.assertEquals(2, partyEntity.performSplit().length);
    }
}
