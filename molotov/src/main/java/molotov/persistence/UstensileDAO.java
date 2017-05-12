package molotov.persistence;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import molotov.entities.Ustensile;

@Dependent
public class UstensileDAO {
	@PersistenceContext(unitName="molotov")
	private EntityManager em;
	
@Resource private UserTransaction ut;
	
	public void saveOrUpdate(Ustensile u) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		ut.begin();
		if(u.getId()==0){
			em.persist(u);
		}
		else{
			em.merge(u);
		}
		ut.commit();
	}
	
	public void remove(long id) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		ut.begin();
		Ustensile u = em.find(Ustensile.class,id);
		
		em.remove(u);
		ut.commit();
	}
	
	public Ustensile getUstensileById(int id){
		return em.find(Ustensile.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ustensile> getAllUstensiles(){
		Query query = em.createNamedQuery("allUstensiles");
		return query.getResultList();
	}
	
}
