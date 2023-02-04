/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.infra.cif.convertors;

import com.app.infra.cif.db.PartyDB;
import java.util.Optional;

/**
 *
 * @author sreep
 */
public interface IDbService {
    public PartyDB select(String id);
    public boolean insert(Optional<PartyDB> optPartyDB);
}
