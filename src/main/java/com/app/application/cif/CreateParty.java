/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif;

import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreep
 */
@Service
public class CreateParty {
    public Optional<String> createParty(){
        return Optional.of("Party Created");
    }
    
}
