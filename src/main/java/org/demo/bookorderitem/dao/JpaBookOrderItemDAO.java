/*
 * D.A.O. for JPA  
 * Created on 17 déc. 2012 ( Time 14:48:56 )
 */

package org.demo.bookorderitem.dao;

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

import org.demo.bookorderitem.bean.BookOrderItem;
import org.demo.bookorderitem.bean.BookOrderItemKey;

public class JpaBookOrderItemDAO extends GenericJpaDao<BookOrderItem, BookOrderItemKey> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for BookOrderItem
	 */
	public JpaBookOrderItemDAO() {
		super(BookOrderItem.class);
	}
	
	/**
	 * Search by BookOrderItem example
	 */
	public List<BookOrderItem> search(final BookOrderItem element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<BookOrderItem> criteriaQuery = criteriaBuilder.createQuery(BookOrderItem.class);
			Root<BookOrderItem> from = criteriaQuery.from(BookOrderItem.class);

			List<Predicate> listP = new ArrayList<Predicate>();

			if ( element.getKey() != null  ) {
				if (CoreUtils.isNotBlank(element.getKey().getBookOrderId())) {
					Predicate predicate = criteriaBuilder.equal(from.get("bookOrderId"), element.getKey().getBookOrderId());
					listP.add(predicate);
				}
				if (CoreUtils.isNotBlank(element.getKey().getBookId())) {
					Predicate predicate = criteriaBuilder.equal(from.get("bookId"), element.getKey().getBookId());
					listP.add(predicate);
				}
			}

			if (CoreUtils.isNotBlank(element.getQuantity())) {
				Predicate predicate = criteriaBuilder.equal(from.get("quantity"), element.getQuantity());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getPrice())) {
				Predicate predicate = criteriaBuilder.equal(from.get("price"), element.getPrice());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<BookOrderItem> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}