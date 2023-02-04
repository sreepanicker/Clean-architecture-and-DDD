/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.infra.cif.convertors;

import com.app.domain.cif.PartyEntity;
import com.app.domain.cif.Type;
import com.app.infra.cif.db.PartyDB;
import java.lang.reflect.Field;
import java.time.LocalTime;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component
public class PartyDBToPartyEnity {

    public PartyEntity convert(PartyDB partyDB) {
        PartyEntity partyEntity;

        if (partyDB.getType().equalsIgnoreCase("join")) {
            partyEntity = new PartyEntity(partyDB.getId(), Type.JOINT, partyDB.getAddress());
        } else {
            partyEntity = new PartyEntity(partyDB.getId(), Type.SINGLE, partyDB.getAddress());
        }

        return partyEntity;
    }

    public Optional<PartyDB> convert(Optional<PartyEntity> optPartyEntity) {
        PartyDB partyDB = null;
        if (!optPartyEntity.isEmpty()) {
            try {
                //Creating party DB
                PartyEntity partyEntity = optPartyEntity.get();
                
                //we need reflection to get the data 
                Field idField = PartyEntity.class.getDeclaredField("id");
                idField.setAccessible(true);
                String id = (String)idField.get(partyEntity);
                
                //type feild 
                Field typeField = PartyEntity.class.getDeclaredField("type");
                typeField.setAccessible(true);
                Type type = (Type) typeField.get(partyEntity);
                
                //address feild;
                Field addressField = PartyEntity.class.getDeclaredField("address");
                addressField.setAccessible(true);
                String address = (String) addressField.get(partyEntity);
                
                String creationTime = LocalTime.now().toString();
                partyDB = new PartyDB(id,type.name(),creationTime,address);
                return Optional.of(partyDB);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return Optional.empty();
    }

}
