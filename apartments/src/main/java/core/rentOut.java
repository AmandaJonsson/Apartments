/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import lombok.Setter;
import lombok.Getter;

/**
 *
 * @author tthera
 */
public class rentOut {
    
    
    /*Unikt sätt att hitta lägenheten
    Adress för lägenheten (adress, postnummer och postadress)
    Beskrivning av lägenhet

    För- och efternamn på den som hyr ut
    Telefonnummer för den som hyr ut
    Mailadress för den som hyr ut*/

    
    
    @Getter
    @Setter
    private String id;
    
    @Getter
    @Setter
    private String adress;
    
    @Getter
    @Setter
    private String description;
    
    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private String phone;
    
    @Getter
    @Setter
    private String mail;
    
    
    
    
    
}
