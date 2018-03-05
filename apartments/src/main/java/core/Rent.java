/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

/**
 *
 * @author amandajonsson
 */
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Model
@Table(name = "rent")
public class Rent implements Serializable {

    @Id
    @Column(nullable=false)
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String description;
    
     @Getter
    @Setter
    private String mail;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int phoneNr;

   

    public Rent(String id, String description, String mail, String name, int phoneNr){
        this.id=id;
        this.description=description;
        this.mail=mail;
        this.name=name;
        this.phoneNr=phoneNr;

    }
    /* A toString method to write out how a rent out ad should look like */
    @Override
    public String toString() {
        return "Apartment(To rent out){" + "id = " + id +  
            "description=" + description + ", mail = " + mail + ", name = " + name + ", phoneNr = " + phoneNr 
             + "'}'";
    } 

}