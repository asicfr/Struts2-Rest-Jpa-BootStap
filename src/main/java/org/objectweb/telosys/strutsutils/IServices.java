package org.objectweb.telosys.strutsutils;

import java.util.List;

/**
 * @author slabbe
 *
 * @param <T>
 * @param <PK>
 */
public interface IServices<T, PK> {

	/**
	 * Load entity
	 * @param id
	 * @return entity
	 */
	T load(final PK id) ;

	/**
	 * Save entity
	 * @param entity
	 * @return entity
	 */
	T save(final T entity);

	/**
	 * Delete entity
	 * @param id
	 */
	void delete(final PK id);

	/**
	 * Search entity
	 * @param element
	 * @return list entities
	 */
	List<T> search(final T element);

}