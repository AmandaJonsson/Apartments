/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import core.RentOut;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author tthera
 */

@Model
@Named("rentOut")
//@SessionScoped
public class RentOutBean implements Serializable {
    
    
    
    
    public void setRentOut () {}
    
    
    public List<RentOut> findAll() {
        return null;
    }
    
    
    public void add () {}
    
    public void update () {}
    
    public void delete () {}
    
}
