/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
import javax.persistence.Embedded;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
*/


/**
 * @author tthera
 */
@NoArgsConstructor
@Entity
@Table(name = "rentOut")
public class RentOut implements Serializable {
    
    
    /*Unikt sätt att hitta lägenheten
    Adress för lägenheten (adress, postnummer och postadress)
    Beskrivning av lägenhet

    För- och efternamn på den som hyr ut
    Telefonnummer för den som hyr ut
    Mailadress för den som hyr ut*/

    
    @Id
    @Column(nullable=false)
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
    private int phoneNr;
    
    @Getter
    @Setter
    private String mail;
    
    @Getter
    @Setter
    private String image;
    
    
    public RentOut (String id, String adress, String description, String name,
            int phoneNr, String mail, String image) {
    this.id = id;
    this.adress = adress;
    this.description = description;
    this.name = name;
    this.phoneNr = phoneNr;
    this.mail = mail;
    this.image = image;
    }
    
    
    /*@Override
    public String toString() {
        return "Apartment(To rent out){" + "id=" + id + ", "adress=" + adress + ", 
            description=" + description + ", name=" + name + ", phoneNr=" + phoneNr 
            + ", mail=" + mail + ", image=" + image '}';
    }*/
    
    
}