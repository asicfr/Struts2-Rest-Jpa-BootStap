/*
 * Service class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */

package org.demo.synopsis.service ;

import java.util.List;

import org.demo.synopsis.bean.Synopsis;
import org.demo.synopsis.dao.JpaSynopsisDAO;
import org.objectweb.telosys.strutsutils.EntityManagerHelper;
import org.objectweb.telosys.strutsutils.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class SynopsisServices implements IServices<Synopsis, Integer> {

	protected final Logger LOG = LoggerFactory.getLogger(SynopsisServices.class);

	public Synopsis load(final Integer id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Synopsis synopsis;
		try {
			EntityManagerHelper.beginTransaction();
			JpaSynopsisDAO synopsisDAO = new JpaSynopsisDAO();
			synopsis = synopsisDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return synopsis ;
	}

	public Synopsis save(final Synopsis entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Synopsis entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaSynopsisDAO synopsisDAO = new JpaSynopsisDAO();
			entityNew = synopsisDAO.update(entity);
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
			JpaSynopsisDAO synopsisDAO = new JpaSynopsisDAO();
			synopsisDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Synopsis> search(final Synopsis synopsis) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Synopsis> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaSynopsisDAO synopsisDAO = new JpaSynopsisDAO();
			liste = synopsisDAO.search(synopsis);
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
