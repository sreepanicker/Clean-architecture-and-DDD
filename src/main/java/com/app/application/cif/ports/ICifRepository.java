/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.application.cif.ports;

import com.app.domain.cif.PartyEntity;
import java.util.Optional;

/**
 *
 * @author sreep
 */
public interface ICifRepository {
    public Optional<PartyEntity> findPartyById(String id);
    public boolean save(Optional<PartyEntity> optPartyEntity);
}
