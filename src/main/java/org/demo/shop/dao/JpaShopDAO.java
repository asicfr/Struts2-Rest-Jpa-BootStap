/*
 * D.A.O. for JPA  
 * Created on 17 déc. 2012 ( Time 15:40:00 )
 */

package org.demo.shop.dao;

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

import org.demo.shop.bean.Shop;

public class JpaShopDAO extends GenericJpaDao<Shop, String> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for Shop
	 */
	public JpaShopDAO() {
		super(Shop.class);
	}
	
	/**
	 * Search by Shop example
	 */
	public List<Shop> search(final Shop element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Shop> criteriaQuery = criteriaBuilder.createQuery(Shop.class);
			Root<Shop> from = criteriaQuery.from(Shop.class);

			List<Predicate> listP = new ArrayList<Predicate>();


			if (CoreUtils.isNotBlank(element.getCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("code"), element.getCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getName())) {
				Predicate predicate = criteriaBuilder.equal(from.get("name"), element.getName());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getAddress1())) {
				Predicate predicate = criteriaBuilder.equal(from.get("address1"), element.getAddress1());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getAddress2())) {
				Predicate predicate = criteriaBuilder.equal(from.get("address2"), element.getAddress2());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getZipCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("zipCode"), element.getZipCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getCity())) {
				Predicate predicate = criteriaBuilder.equal(from.get("city"), element.getCity());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getCountryCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("countryCode"), element.getCountryCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getPhone())) {
				Predicate predicate = criteriaBuilder.equal(from.get("phone"), element.getPhone());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getEmail())) {
				Predicate predicate = criteriaBuilder.equal(from.get("email"), element.getEmail());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getExecutive())) {
				Predicate predicate = criteriaBuilder.equal(from.get("executive"), element.getExecutive());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<Shop> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}