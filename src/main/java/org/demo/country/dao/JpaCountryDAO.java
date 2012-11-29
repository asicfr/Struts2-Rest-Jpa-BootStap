/*
 * Dao class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */

package org.demo.country.dao ;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.demo.country.bean.Country;
import org.objectweb.telosys.strutsutils.CoreUtils;
import org.objectweb.telosys.strutsutils.GenericJpaDao;




public class JpaCountryDAO extends GenericJpaDao<Country, String> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for Country
	 */
	public JpaCountryDAO() {
		super(Country.class);
	}
	
	/**
	 * Search by Country example
	 */
	public List<Country> search(final Country element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Country> criteriaQuery = criteriaBuilder.createQuery(Country.class);
			Root<Country> from = criteriaQuery.from(Country.class);

			List<Predicate> listP = new ArrayList<Predicate>();

			if (CoreUtils.isNotBlank(element.getCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("code"), element.getCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getName())) {
				Predicate predicate = criteriaBuilder.equal(from.get("name"), element.getName());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<Country> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}