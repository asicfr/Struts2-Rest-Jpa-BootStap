/*
 * Service class 
 * Created on 17 déc. 2012 ( Time 15:39:59 )
 */

package org.demo.country.service;

import java.util.List;

import org.demo.country.bean.Country;
import org.demo.country.dao.JpaCountryDAO;
import org.telosys.starterkits.strutsjpa.EntityManagerHelper;
import org.telosys.starterkits.strutsjpa.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class CountryServices implements IServices<Country, String> {

	protected final Logger LOG = LoggerFactory.getLogger(CountryServices.class);

	public Country load(final String id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Country country;
		try {
			EntityManagerHelper.beginTransaction();
			JpaCountryDAO countryDAO = new JpaCountryDAO();
			country = countryDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return country ;
	}

	public Country save(final Country entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Country entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaCountryDAO countryDAO = new JpaCountryDAO();
			entityNew = countryDAO.update(entity);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return entityNew;
	}

	public void delete(final String id) {
		if (LOG.isDebugEnabled()) LOG.debug("delete");
		try {
			EntityManagerHelper.beginTransaction();
			JpaCountryDAO countryDAO = new JpaCountryDAO();
			countryDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Country> search(final Country country) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Country> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaCountryDAO countryDAO = new JpaCountryDAO();
			liste = countryDAO.search(country);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return liste;
	}

}
