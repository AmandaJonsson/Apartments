/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import core.RentOut;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author tthera
 */


//@Stateless

public class RentOutCollection extends AbstractQuery<RentOut, String>{
    
    
    @PersistenceContext(unitName ="")       //Vad ska den heta?
    private EntityManager em;
    
    
    public RentOutCollection() {
        super(RentOut.class, QRentOut.rentOut);
    }
    
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    //Oklart om den ska vara såhär? Används den?
    public List<RentOut> findByName(String personName) {
        QRentOut rentOut = QRentOut.rentOut;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<RentOut> foundName = qf.select(rentOut)
                .from(rentOut)
                .where(rentOut.name.eq(personName))
                .fetch();
        System.out.print(foundName);
        return foundName;

    }

    
    
}
