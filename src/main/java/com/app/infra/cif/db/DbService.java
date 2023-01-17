/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.infra.cif.db;

import com.app.infra.cif.convertors.IDbService;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sreep
 */

//just for autowiring 
@Repository
public class DbService implements IDbService {

    @Override
    public PartyDB select(String id) {
       if (id.contains("5")){
           return null;
       }
       return new PartyDB(id,"JOINT","2010-01-12");
       
    }
    
}
