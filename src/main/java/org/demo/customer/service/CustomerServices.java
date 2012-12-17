/*
 * Service class 
 * Created on 17 déc. 2012 ( Time 14:48:56 )
 */

package org.demo.customer.service;

import java.util.List;

import org.demo.customer.bean.Customer;
import org.demo.customer.dao.JpaCustomerDAO;
import org.telosys.starterkits.strutsjpa.EntityManagerHelper;
import org.telosys.starterkits.strutsjpa.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class CustomerServices implements IServices<Customer, String> {

	protected final Logger LOG = LoggerFactory.getLogger(CustomerServices.class);

	public Customer load(final String id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Customer customer;
		try {
			EntityManagerHelper.beginTransaction();
			JpaCustomerDAO customerDAO = new JpaCustomerDAO();
			customer = customerDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return customer ;
	}

	public Customer save(final Customer entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Customer entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaCustomerDAO customerDAO = new JpaCustomerDAO();
			entityNew = customerDAO.update(entity);
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
			JpaCustomerDAO customerDAO = new JpaCustomerDAO();
			customerDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Customer> search(final Customer customer) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Customer> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaCustomerDAO customerDAO = new JpaCustomerDAO();
			liste = customerDAO.search(customer);
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
