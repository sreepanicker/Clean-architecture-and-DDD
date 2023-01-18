/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sreep
 */
@RestController
@RequestMapping(path = "/api/cif/v1/party")
public class ApplicationServiceCreateParty {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createParty() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Created Party Object");
    }
}
