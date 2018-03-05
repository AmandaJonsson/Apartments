
package dao;

//import com.querydsl.jpa.impl.JPAQueryFactory;
import core.RentOut;
//import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import core.QRentOut;


/**
 * The RentOut Collection class
 * @author tthera (Therese Sturesson)
 */

@Stateless
public class RentOutCollection extends AbstractQuery<RentOut, String> {
    

    /* The connection to the persistence file and glassfish */
    @PersistenceContext(unitName ="apartment_persistence")
    
    /* The entity manager varible */
    private EntityManager em;
    
    
    /* The constructor for the class */
    public RentOutCollection() {
        super(RentOut.class, QRentOut.rentOut);
    }
    
    
    /* The getter for the entity manager */
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    
    /* The setter for the entity manager */
   @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
 
    /*
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
    */
    
}
