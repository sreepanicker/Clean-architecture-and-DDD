/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.application.cif.ports;

import com.app.application.cif.convertor.UpdatePartyAddressConvertor;
import java.util.Optional;

/**
 *
 * @author sreep
 */
public interface IUpdatePartyAddress {
    public Optional<UpdatePartyAddressConvertor.UpdateAddressDTO> updateAddress(Optional<UpdatePartyAddressConvertor.UpdateAddressDTO> optAddress);
}
