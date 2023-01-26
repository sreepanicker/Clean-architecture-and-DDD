/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.infra.cif;

import com.app.application.cif.ports.ICifRepository;
import com.app.domain.cif.Party;
import com.app.infra.cif.convertors.IDbService;
import com.app.infra.cif.convertors.PartyDBToPartyEnity;
import com.app.infra.cif.db.PartyDB;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Optional<Party> findPartyById(String id) {
        PartyDB partyDb = iDbService.select(id);
        if (!Objects.isNull(partyDb)) {
            Party party = partyDbToEnity.convert(partyDb);
            return Optional.of(party);
        }
        return Optional.empty();
    }
    
    // Save opertion 
    
    //Logic 
    // read the Party Domain Enitity
    // Read the domain events
    // Publish the domain events
    //Event publish should  maintain the subscriber details
    
    
}
