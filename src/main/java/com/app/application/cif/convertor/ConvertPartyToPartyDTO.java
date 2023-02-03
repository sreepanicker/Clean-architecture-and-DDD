/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif.convertor;

import com.app.domain.cif.PartyEntity;
import com.app.domain.cif.Type;
import java.lang.reflect.Field;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component
public class ConvertPartyToPartyDTO {

    public FindPartyDTO convert(PartyEntity partyEntity) {
        FindPartyDTO partyDTO = new FindPartyDTO();
     
        try {
            //Reading the ID data 
            Field field = PartyEntity.class.getDeclaredField("id");
            field.setAccessible(true);
            partyDTO.setId((String) field.get(partyEntity));
            //Reading the type data 
            field = PartyEntity.class.getDeclaredField("type");
            field.setAccessible(true);
            Type type = (Type)field.get(partyEntity);
            partyDTO.setType(type.name());

            partyDTO.setErrorMessage("");
        } catch (Exception e) {
            //throw exception ., need to handle the code 
            System.out.println(e);
        }
        return partyDTO;
    }
}
