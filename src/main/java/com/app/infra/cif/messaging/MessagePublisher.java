/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.infra.cif.messaging;

import com.app.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component
public class MessagePublisher {
    @Autowired
    private ApplicationEventPublisher publisher;
    
    
    public void publish(Event event){
        publisher.publishEvent(event);
        
    }
}
