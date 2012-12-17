/*
 * D.A.O. for JPA  
 * Created on 17 déc. 2012 ( Time 14:48:55 )
 */

package org.demo.bookorder.dao;

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

import org.demo.bookorder.bean.BookOrder;

public class JpaBookOrderDAO extends GenericJpaDao<BookOrder, Integer> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for BookOrder
	 */
	public JpaBookOrderDAO() {
		super(BookOrder.class);
	}
	
	/**
	 * Search by BookOrder example
	 */
	public List<BookOrder> search(final BookOrder element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<BookOrder> criteriaQuery = criteriaBuilder.createQuery(BookOrder.class);
			Root<BookOrder> from = criteriaQuery.from(BookOrder.class);

			List<Predicate> listP = new ArrayList<Predicate>();


			if (CoreUtils.isNotBlank(element.getId())) {
				Predicate predicate = criteriaBuilder.equal(from.get("id"), element.getId());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getShopCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("shopCode"), element.getShopCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getCustomerCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("customerCode"), element.getCustomerCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getEmployeeCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("employeeCode"), element.getEmployeeCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getDate())) {
				Predicate predicate = criteriaBuilder.equal(from.get("date"), element.getDate());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getState())) {
				Predicate predicate = criteriaBuilder.equal(from.get("state"), element.getState());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<BookOrder> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}