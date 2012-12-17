/*
 * D.A.O. for JPA  
 * Created on 17 déc. 2012 ( Time 14:48:55 )
 */

package org.demo.badge.dao;

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

import org.demo.badge.bean.Badge;

public class JpaBadgeDAO extends GenericJpaDao<Badge, Integer> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for Badge
	 */
	public JpaBadgeDAO() {
		super(Badge.class);
	}
	
	/**
	 * Search by Badge example
	 */
	public List<Badge> search(final Badge element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Badge> criteriaQuery = criteriaBuilder.createQuery(Badge.class);
			Root<Badge> from = criteriaQuery.from(Badge.class);

			List<Predicate> listP = new ArrayList<Predicate>();


			if (CoreUtils.isNotBlank(element.getBadgeNumber())) {
				Predicate predicate = criteriaBuilder.equal(from.get("badgeNumber"), element.getBadgeNumber());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getAuthorizationLevel())) {
				Predicate predicate = criteriaBuilder.equal(from.get("authorizationLevel"), element.getAuthorizationLevel());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getEndOfValidity())) {
				Predicate predicate = criteriaBuilder.equal(from.get("endOfValidity"), element.getEndOfValidity());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<Badge> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}