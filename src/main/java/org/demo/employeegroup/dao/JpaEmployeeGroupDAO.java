/*
 * D.A.O. for JPA  
 * Created on 17 déc. 2012 ( Time 15:40:00 )
 */

package org.demo.employeegroup.dao;

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

import org.demo.employeegroup.bean.EmployeeGroup;
import org.demo.employeegroup.bean.EmployeeGroupKey;

public class JpaEmployeeGroupDAO extends GenericJpaDao<EmployeeGroup, EmployeeGroupKey> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for EmployeeGroup
	 */
	public JpaEmployeeGroupDAO() {
		super(EmployeeGroup.class);
	}
	
	/**
	 * Search by EmployeeGroup example
	 */
	public List<EmployeeGroup> search(final EmployeeGroup element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<EmployeeGroup> criteriaQuery = criteriaBuilder.createQuery(EmployeeGroup.class);
			Root<EmployeeGroup> from = criteriaQuery.from(EmployeeGroup.class);

			List<Predicate> listP = new ArrayList<Predicate>();

			if ( element.getKey() != null  ) {
				if (CoreUtils.isNotBlank(element.getKey().getEmployeeCode())) {
					Predicate predicate = criteriaBuilder.equal(from.get("employeeCode"), element.getKey().getEmployeeCode());
					listP.add(predicate);
				}
				if (CoreUtils.isNotBlank(element.getKey().getGroupId())) {
					Predicate predicate = criteriaBuilder.equal(from.get("groupId"), element.getKey().getGroupId());
					listP.add(predicate);
				}
			}

			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<EmployeeGroup> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}