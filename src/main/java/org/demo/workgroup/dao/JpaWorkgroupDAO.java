/*
 * Dao class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */

package org.demo.workgroup.dao ;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.demo.workgroup.bean.Workgroup;
import org.objectweb.telosys.strutsutils.CoreUtils;
import org.objectweb.telosys.strutsutils.GenericJpaDao;




public class JpaWorkgroupDAO extends GenericJpaDao<Workgroup, Short> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for Workgroup
	 */
	public JpaWorkgroupDAO() {
		super(Workgroup.class);
	}
	
	/**
	 * Search by Workgroup example
	 */
	public List<Workgroup> search(final Workgroup element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Workgroup> criteriaQuery = criteriaBuilder.createQuery(Workgroup.class);
			Root<Workgroup> from = criteriaQuery.from(Workgroup.class);

			List<Predicate> listP = new ArrayList<Predicate>();

			if (CoreUtils.isNotBlank(element.getId())) {
				Predicate predicate = criteriaBuilder.equal(from.get("id"), element.getId());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getName())) {
				Predicate predicate = criteriaBuilder.equal(from.get("name"), element.getName());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getDescription())) {
				Predicate predicate = criteriaBuilder.equal(from.get("description"), element.getDescription());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getCreationDate())) {
				Predicate predicate = criteriaBuilder.equal(from.get("creationDate"), element.getCreationDate());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<Workgroup> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}