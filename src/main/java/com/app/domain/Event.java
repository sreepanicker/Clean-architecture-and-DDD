/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.domain;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author sreep
 */
public abstract class Event {
    private final UUID eventId;
    private final LocalDateTime creationTime;
    
    public Event(){
        this.eventId = UUID.randomUUID();
        this.creationTime = LocalDateTime.now();
    }   
    
}
