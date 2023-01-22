/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import com.app.application.cif.CreateParty;
import com.app.application.cif.convertor.ConvertCreatePartyObjects.CreatePartyData;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author sreep 
 * This test class provide unit test cases for controller , i.e CreateParty
 */


@WebMvcTest(ApplicationControllerCreatePartyTests.class)
@AutoConfigureMockMvc
public class ApplicationControllerCreatePartyTests {
    //Mock MVC feild
    @Autowired
    private MockMvc mockMVC;
    
    @MockBean
    private CreateParty createParty; 
    
    private CreatePartyData createPartyDTO;
    
    @BeforeEach
    void init(){
        createPartyDTO = new CreatePartyData("id","Join","72 Rd");
    }
    
    @Test
    public void create_party_test1()throws Exception{
        
        
        when(createParty.createParty(createPartyDTO)).thenReturn(Optional.of(createPartyDTO));
        
        mockMVC.perform(post("/api/cif/v1/party/").contentType(MediaType.APPLICATION_JSON).content("{id:'100',type:'SINGLE','address:'72'}"))
                .andExpect(status().is4xxClientError());
        
        
    }
    
}