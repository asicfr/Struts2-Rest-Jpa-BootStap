package org.objectweb.telosys.strutsutils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author slabbe
 *
 * @param <T>
 * @param <PK>
 */
public abstract class GenericJpaDao<T, PK extends java.io.Serializable> {

	private final Class<T> persistentClass;

	/**
	 * Constructor
	 * @param persistentClass
	 */
	public GenericJpaDao(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * Find entity By Id
	 * @param <T>
	 * @param id
	 * @return
	 */
	public <T> T findById(final PK id) {
		final EntityManager em = getEntityManager();
		return (T) em.find(this.persistentClass, id);
	}

	/**
	 * Find entity By name query
	 * @param queryName
	 * @param queryParams
	 * @return
	 */
	public List<T> findByNamedQuery(final String queryName, final Map<String, Object> queryParams) {
		final EntityManager em = getEntityManager();
		final Query query = em.createNamedQuery(queryName);

		final Iterator<String> i = queryParams.keySet().iterator();
		while (i.hasNext()) {
			String key = i.next();
			query.setParameter(key, queryParams.get(key));
		}

		return query.getResultList();
	}

	/**
	 * Load a list of entities
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> Collection<T> loadList(final String query) {
		final EntityManager em = getEntityManager();
		final TypedQuery q = em.createQuery(query, this.persistentClass);
		return q.getResultList();
	}

	/**
	 * Load all entities
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> loadAll() {
		final EntityManager em = getEntityManager();
		final Query query = em.createQuery("from " + persistentClass.getName());
		return query.getResultList();
	}

	/**
	 * Insert entity
	 * @param <T>
	 * @return
	 */
	public <T> T insert(final T entity) {
		final EntityManager em = getEntityManager();
		em.persist(entity);
		return (entity);
	}

	/**
	 * Update entity
	 * @param <T>
	 * @param entity
	 * @return
	 */
	public <T> T update(T entity) {
		final EntityManager em = getEntityManager();
		entity = em.merge(entity);
		return entity;
	}

	/**
	 * Delete entity by pk
	 * @param pk
	 */
	public void delete(final PK pk) {
		final EntityManager em = getEntityManager();
		final T entity = em.find(this.persistentClass, pk);
		if (entity != null) {
			em.remove(entity);
		}
	}

	/**
	 * Delete entity
	 * @param entity
	 */
	public void delete(final T entity) {
		final EntityManager em = getEntityManager();
		if (entity != null) {
			em.refresh(entity);
			em.remove(entity);
		}
	}

	// ***************************************************************************************

	/**
	 * Get EntityManager
	 * @return EntityManager
	 */
	protected EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

}
