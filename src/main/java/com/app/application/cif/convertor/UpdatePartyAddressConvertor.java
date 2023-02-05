/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.application.cif.convertor;

/**
 *
 * @author sreep
 */
public class UpdatePartyAddressConvertor {
    
    public record UpdateAddressDTO(String id, String address, String message){
        public UpdateAddressDTO(String message){
            this("","",message);
        }
        public UpdateAddressDTO(String id, String address){
            this(id,address,"");
        }
        
    }
    
    //public 
    
}
