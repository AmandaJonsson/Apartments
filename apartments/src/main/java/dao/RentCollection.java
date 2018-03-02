/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import core.Qrent;
import core.rent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author tthera
 */
public class RentCollection extends AbstractQuery<rent, String>{

  
    @PersistenceContext(unitName ="")
    private EntityManager em;
    
    
    public RentCollection() {
        super(rent.class, Qrent.rent);
    }
    
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    
   @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    
}
