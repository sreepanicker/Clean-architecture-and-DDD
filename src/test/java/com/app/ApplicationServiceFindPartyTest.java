/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import com.app.application.cif.FindParty;
import com.app.application.cif.convertor.PartyDTO;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author sreep
 * This Test case won't load the Server , only use the mock bean to perform the test
 */
@WebMvcTest(ApplicationServiceFindParty.class)
public class ApplicationServiceFindPartyTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private FindParty findParty;
    
    PartyDTO partyDTO;
    
    @BeforeEach
    public void createPartyDto(){
        partyDTO = new PartyDTO();
        partyDTO.setId("20");
        partyDTO.setType("JOIN");       
    }
    
    @Test
    public void findAParty() throws Exception{
      
       when(findParty.findPartyByid("20")).thenReturn( Optional.of(partyDTO));
       mockMvc.perform(get("/api/cif/v1/party/20"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("20")));
        
        
    }
    @Test
    public void findAPartyInvaild() throws Exception{
      
       when(findParty.findPartyByid("5")).thenReturn( Optional.empty());
       mockMvc.perform(get("/api/cif/v1/party/20"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("Invaild ")));
        
        
    }
}
