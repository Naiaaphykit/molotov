package molotov.persistence;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import molotov.entities.Dose;

@Dependent
public class DoseDAO {
	@PersistenceContext(unitName = "molotov")
	private EntityManager em;

	@Resource
	private UserTransaction transaction;

	public void saveOrUpdate(Dose dose) throws NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		transaction.begin();
		if (dose.getId() == 0) {
			em.persist(dose);
		} else {
			em.merge(dose);
		}
		transaction.commit();
	}

	public void remove(Dose dose) throws SecurityException, IllegalStateException, NotSupportedException,
			SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		remove(dose.getId());
	}

	public void remove(long id) throws NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException {
		transaction.begin();
		Dose d = em.find(Dose.class, id);
		em.remove(d);
		transaction.commit();

	}
}
