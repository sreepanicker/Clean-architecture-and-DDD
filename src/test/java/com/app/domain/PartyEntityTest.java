/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain;

import com.app.domain.cif.Party;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sreep
 */
public class PartyEntityTest {
    
    @Test
    public void validateKyc(){
        
        Party party = new Party();
        assert(party).validateKYC();
        
    }
    
}
