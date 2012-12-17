/*
 * D.A.O. for JPA  
 * Created on 17 déc. 2012 ( Time 14:48:57 )
 */

package org.demo.review.dao;

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

import org.demo.review.bean.Review;
import org.demo.review.bean.ReviewKey;

public class JpaReviewDAO extends GenericJpaDao<Review, ReviewKey> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for Review
	 */
	public JpaReviewDAO() {
		super(Review.class);
	}
	
	/**
	 * Search by Review example
	 */
	public List<Review> search(final Review element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Review> criteriaQuery = criteriaBuilder.createQuery(Review.class);
			Root<Review> from = criteriaQuery.from(Review.class);

			List<Predicate> listP = new ArrayList<Predicate>();

			if ( element.getKey() != null  ) {
				if (CoreUtils.isNotBlank(element.getKey().getCustomerCode())) {
					Predicate predicate = criteriaBuilder.equal(from.get("customerCode"), element.getKey().getCustomerCode());
					listP.add(predicate);
				}
				if (CoreUtils.isNotBlank(element.getKey().getBookId())) {
					Predicate predicate = criteriaBuilder.equal(from.get("bookId"), element.getKey().getBookId());
					listP.add(predicate);
				}
			}

			if (CoreUtils.isNotBlank(element.getReviewText())) {
				Predicate predicate = criteriaBuilder.equal(from.get("reviewText"), element.getReviewText());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getReviewNote())) {
				Predicate predicate = criteriaBuilder.equal(from.get("reviewNote"), element.getReviewNote());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getCreation())) {
				Predicate predicate = criteriaBuilder.equal(from.get("creation"), element.getCreation());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getLastUpdate())) {
				Predicate predicate = criteriaBuilder.equal(from.get("lastUpdate"), element.getLastUpdate());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<Review> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}