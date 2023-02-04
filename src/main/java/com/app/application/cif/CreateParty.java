/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif;

import com.app.application.cif.convertor.ConvertCreatePartyObjects;
import com.app.application.cif.convertor.ConvertCreatePartyObjects.CreatePartyData;
import com.app.application.cif.ports.ICifRepository;
import com.app.application.cif.ports.ICreateParty;
import com.app.domain.cif.PartyCreatedEvent;
import com.app.domain.cif.PartyEntity;
//import com.app.application.cif.convertor.CreatePartyDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreep
 */
@Service
public class CreateParty implements ICreateParty {

    @Autowired
    ConvertCreatePartyObjects convertor;
    @Autowired
    ICifRepository cifReporty;

    @Override
    public Optional<CreatePartyData> createParty(CreatePartyData createPartyDTO) {

        Optional<PartyEntity> optParty = convertor.convert(createPartyDTO);
        if (!optParty.isEmpty()) {

            //Validate the KYC
            PartyEntity partyEntity = optParty.get();
            if (partyEntity.performKYCValidation()) {
                partyEntity.addNewEvents(new PartyCreatedEvent(createPartyDTO.id()));
                boolean partyStatus = cifReporty.save(Optional.of(partyEntity));
                if (partyStatus) {
                    CreatePartyData returnDTO = new CreatePartyData(createPartyDTO.id(), "Created successfully");
                    return Optional.of(returnDTO);
                } else {
                    CreatePartyData returnDTO = new CreatePartyData(createPartyDTO.id(), "Unable to create Party");
                    return Optional.of(returnDTO);
                }
            }

        }
        return Optional.empty();
    }

}
