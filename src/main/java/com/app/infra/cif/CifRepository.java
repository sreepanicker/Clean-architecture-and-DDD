/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.infra.cif;

import com.app.application.cif.ports.ICifRepository;
import com.app.domain.cif.PartyCreatedEvent;
import com.app.domain.cif.PartyEntity;
import com.app.infra.cif.convertors.IDbService;
import com.app.infra.cif.convertors.PartyDBToPartyEnity;
import com.app.infra.cif.db.PartyDB;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sreep This class provide the implementation for ICifReporistory Class
 * talks to the DB and get the details from the Party ID
 */
@Repository
public class CifRepository implements ICifRepository {
    //Access the DB for getting the data

    @Autowired
    private IDbService iDbService;
    //converter convert DB object to an Enity object, which has rules associated with. 
    @Autowired
    private PartyDBToPartyEnity partyDbToEnity;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Optional<PartyEntity> findPartyById(String id) {
        PartyDB partyDb = iDbService.select(id);
        if (!Objects.isNull(partyDb)) {
            PartyEntity partyEntity = partyDbToEnity.convert(partyDb);
            return Optional.of(partyEntity);
        }
        return Optional.empty();
    }

    // Save opertion 
    //Logic 
    // read the Party Domain Enitity
    // Read the domain events
    // Publish the domain events
    //Event publish should  maintain the subscriber details
    @Override
    public boolean save(Optional<PartyEntity> optPartyEntity) {

        if (!optPartyEntity.isEmpty()) {
            Optional<PartyDB> optPartyDB = partyDbToEnity.convert(optPartyEntity);
            if (!optPartyDB.isEmpty()) {
                PartyDB partyDB = optPartyDB.get();
                if (iDbService.insert(Optional.of(partyDB))) {
                    PartyEntity partyEntity = optPartyEntity.get();
                    partyEntity.getEvents().forEach((e) -> {
                        applicationEventPublisher.publishEvent(e);
                    });
                    if (!partyEntity.getEvents().isEmpty()) {
                        partyEntity.getEvents().clear();
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
