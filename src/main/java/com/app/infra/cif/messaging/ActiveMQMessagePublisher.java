/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.infra.cif.messaging;

import com.app.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component
public class ActiveMQMessagePublisher{
        
    @Autowired
    private JmsTemplate  amqpTemplate;
    
    @Value("${queue}")
    String queue;
    
    public void publish(Event event){
        amqpTemplate.convertAndSend(queue,event);
        
    }
    
}
