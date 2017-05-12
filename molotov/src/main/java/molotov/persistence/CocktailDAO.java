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

import molotov.entities.Cocktail;

@Dependent
public class CocktailDAO {
	@PersistenceContext(unitName="") private EntityManager em;
	@Resource private UserTransaction ut;
	
	public void saveOrUpdate(Cocktail c) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		ut.begin();
		if(c.getId()==0){
			em.persist(c);
		}else{
			em.merge(c);
		}
		ut.commit();
	}
	
	public void remove(Cocktail c){
		em.remove(c.getId());
	}
	
	public Cocktail getCocktailById(long id){
		return em.find(Cocktail.class, id);
	}
	
	public List<Cocktail> getAllCocktails(){
		Query query = em.createNamedQuery("allCocktails");
		return query.getResultList();
	}
}
