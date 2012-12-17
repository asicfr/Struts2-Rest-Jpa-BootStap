/*
 * Service class 
 * Created on 17 déc. 2012 ( Time 15:40:00 )
 */

package org.demo.publisher.service;

import java.util.List;

import org.demo.publisher.bean.Publisher;
import org.demo.publisher.dao.JpaPublisherDAO;
import org.telosys.starterkits.strutsjpa.EntityManagerHelper;
import org.telosys.starterkits.strutsjpa.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class PublisherServices implements IServices<Publisher, Integer> {

	protected final Logger LOG = LoggerFactory.getLogger(PublisherServices.class);

	public Publisher load(final Integer id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Publisher publisher;
		try {
			EntityManagerHelper.beginTransaction();
			JpaPublisherDAO publisherDAO = new JpaPublisherDAO();
			publisher = publisherDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return publisher ;
	}

	public Publisher save(final Publisher entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Publisher entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaPublisherDAO publisherDAO = new JpaPublisherDAO();
			entityNew = publisherDAO.update(entity);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return entityNew;
	}

	public void delete(final Integer id) {
		if (LOG.isDebugEnabled()) LOG.debug("delete");
		try {
			EntityManagerHelper.beginTransaction();
			JpaPublisherDAO publisherDAO = new JpaPublisherDAO();
			publisherDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Publisher> search(final Publisher publisher) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Publisher> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaPublisherDAO publisherDAO = new JpaPublisherDAO();
			liste = publisherDAO.search(publisher);
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
