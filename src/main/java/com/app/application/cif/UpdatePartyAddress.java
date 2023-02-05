/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif;

import com.app.application.cif.convertor.UpdatePartyAddressConvertor.UpdateAddressDTO;
import com.app.application.cif.ports.ICifRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.app.application.cif.ports.IUpdatePartyAddress;
import com.app.domain.cif.PartyEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sreep
 */
@Service
public class UpdatePartyAddress implements IUpdatePartyAddress {

    @Autowired
    private ICifRepository cifRepository;

    @Override
    public Optional<UpdateAddressDTO> updateAddress(Optional<UpdateAddressDTO> optAddress) {

        Optional<UpdateAddressDTO> optreturnAddress;
        // get the Party by ID - use the repository 
        if (!optAddress.isEmpty()) {
            Optional<PartyEntity> optParty = cifRepository.findPartyById(optAddress.get().id());
            if (!optParty.isEmpty()) {
                PartyEntity partyEntity = optParty.get();
                partyEntity.updateAddress(optAddress.get().address());
                if (partyEntity.performKYCValidation()) {
                    if (cifRepository.save(Optional.of(partyEntity))){
                        return optreturnAddress = Optional.of(new UpdateAddressDTO("Success"));
                    }                  
                }
            }
        }
        optreturnAddress = Optional.of(new UpdateAddressDTO("Failed"));
        return optreturnAddress;
    }

}
