package dao;

/**
 * @author emilia
 */
import javax.persistence.EntityManager;


public abstract class AbstractDAO<TDao, KDao> {

    private final Class<TDao> classDao;
   
    // To be overridden by subclasses
    public abstract EntityManager getEntityManager();
    // This one if for testing outside container
    public abstract void setEntityManager(EntityManager em);

    protected AbstractDAO(Class<TDao> clazzDao) {
        
        this.classDao = clazzDao;
    }

     // Updated as result
    public TDao update(TDao t) {

        return getEntityManager().merge(t);
    }
    
    public void create(TDao tdao) {
        getEntityManager().persist(tdao);
        flush();    // Because of Exceptionhandling (else will get EJBException)
    }
    
    

    public TDao find(KDao id) {
        return getEntityManager().find(classDao, id);
    }


    public void delete(KDao id) {
        TDao t = getEntityManager().getReference(classDao, id);
        getEntityManager().remove(t);
    }

   
    protected void flush() {
        getEntityManager().flush();
    }
}
