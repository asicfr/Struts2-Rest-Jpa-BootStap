/*
 * D.A.O. for JPA  
 * Created on 17 déc. 2012 ( Time 14:48:57 )
 */

package org.demo.synopsis.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.telosys.starterkits.strutsjpa.CoreUtils;
import org.telosys.starterkits.strutsjpa.GenericJpaDao;

import org.demo.synopsis.bean.Synopsis;

public class JpaSynopsisDAO extends GenericJpaDao<Synopsis, Integer> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for Synopsis
	 */
	public JpaSynopsisDAO() {
		super(Synopsis.class);
	}
	
	/**
	 * Search by Synopsis example
	 */
	public List<Synopsis> search(final Synopsis element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Synopsis> criteriaQuery = criteriaBuilder.createQuery(Synopsis.class);
			Root<Synopsis> from = criteriaQuery.from(Synopsis.class);

			List<Predicate> listP = new ArrayList<Predicate>();


			if (CoreUtils.isNotBlank(element.getBookId())) {
				Predicate predicate = criteriaBuilder.equal(from.get("bookId"), element.getBookId());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getSynopsis())) {
				Predicate predicate = criteriaBuilder.equal(from.get("synopsis"), element.getSynopsis());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<Synopsis> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}