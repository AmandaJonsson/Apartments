
package dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import core.RentOut;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import core.QRentOut;


/**
 * @author tthera
 */

@Stateless
public class RentOutCollection extends AbstractQuery<RentOut, String>
{
    

    @PersistenceContext(unitName ="apartment_persistence")
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

