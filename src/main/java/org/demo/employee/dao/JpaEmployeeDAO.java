/*
 * D.A.O. for JPA  
 * Created on 17 déc. 2012 ( Time 14:48:56 )
 */

package org.demo.employee.dao;

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

import org.demo.employee.bean.Employee;

public class JpaEmployeeDAO extends GenericJpaDao<Employee, String> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for Employee
	 */
	public JpaEmployeeDAO() {
		super(Employee.class);
	}
	
	/**
	 * Search by Employee example
	 */
	public List<Employee> search(final Employee element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
			Root<Employee> from = criteriaQuery.from(Employee.class);

			List<Predicate> listP = new ArrayList<Predicate>();


			if (CoreUtils.isNotBlank(element.getCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("code"), element.getCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getShopCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("shopCode"), element.getShopCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getFirstName())) {
				Predicate predicate = criteriaBuilder.equal(from.get("firstName"), element.getFirstName());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getLastName())) {
				Predicate predicate = criteriaBuilder.equal(from.get("lastName"), element.getLastName());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getManager())) {
				Predicate predicate = criteriaBuilder.equal(from.get("manager"), element.getManager());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getBadgeNumber())) {
				Predicate predicate = criteriaBuilder.equal(from.get("badgeNumber"), element.getBadgeNumber());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getEmail())) {
				Predicate predicate = criteriaBuilder.equal(from.get("email"), element.getEmail());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<Employee> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}