package org.telosys.starterkits.strutsjpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * EntityManagerHelper
 * @author slabbe
 */
public class EntityManagerHelper {

	private static final String JPA_TEST = "jpaderby";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(JPA_TEST);
	private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();
	private static final Logger LOG = LoggerFactory.getLogger(EntityManagerHelper.class);

	/**
	 * Get EntityManager
	 * @return EntityManager
	 */
	public static EntityManager getEntityManager() {
		EntityManager manager = threadLocal.get();
		if (manager == null || manager.isOpen() == false) {
			manager = emf.createEntityManager();
			threadLocal.set(manager);
		}
		return manager;
	}

	/**
	 * Get known Entities list
	 * @return Entities names list 
	 */
	public static List<String> getEntityList() {
		List<String> liste = new ArrayList<String>(emf.getMetamodel().getEntities().size());
		for (EntityType<?> entite : emf.getMetamodel().getEntities()) {
			liste.add(entite.getJavaType().getSimpleName().toLowerCase());
		}
		return liste;
	}

	/**
	 * Initialize EntityManager
	 */
	public static void initializeEntityManager() {
		getEntityManager();
	}

	/**
	 * Close EntityManager
	 */
	public static void closeEntityManager() {
		final EntityManager em = threadLocal.get();
		threadLocal.set(null);
		closeEm(em);
	}

	/**
	 * Commit and Close EntityManager
	 */
	public static void commitAndCloseEntityManager() {
		final EntityManager em = threadLocal.get();
		try {
			if (em != null) {
				em.getTransaction().commit();
			}
		} finally {
			threadLocal.set(null);
			closeEm(em);
		}
	}

	/**
	 * Start tx
	 */
	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	/**
	 * Commit
	 */
	public static void commit() {
		getEntityManager().getTransaction().commit();
	}

	/**
	 * RollBack
	 */
	public static void rollback() {
		getEntityManager().getTransaction().rollback();
	}

	/**
	 * Set rollback only
	 */
	public static void setRollbackOnly() {
		getEntityManager().getTransaction().setRollbackOnly();
	}

	/**
	 * Check if EntotyManager closed
	 * @return true or false
	 */
	public static boolean isCloseEntityManager() {
		EntityManager manager = threadLocal.get();
		if (manager == null || manager.isOpen() == false) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Close EntityManager
	 * @param em EntityManager
	 */
	private static void closeEm(final EntityManager em) {
		try {
			if (em != null) {
				em.close();
			}
		} catch(Exception ex) {
			LOG.error("Close Em error", ex);
		}
	}
}