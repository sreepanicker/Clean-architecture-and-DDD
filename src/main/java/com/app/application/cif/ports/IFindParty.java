/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.application.cif.ports;

import com.app.application.cif.convertor.FindPartyDTO;
import java.util.Optional;

/**
 *
 * @author sreep
 */
public interface IFindParty {
    public Optional<FindPartyDTO> findPartyByid(String partyId) ;
    
}
