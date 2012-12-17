/*
 * Service class 
 * Created on 17 déc. 2012 ( Time 15:39:59 )
 */

package org.demo.bookorder.service;

import java.util.List;

import org.demo.bookorder.bean.BookOrder;
import org.demo.bookorder.dao.JpaBookOrderDAO;
import org.telosys.starterkits.strutsjpa.EntityManagerHelper;
import org.telosys.starterkits.strutsjpa.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class BookOrderServices implements IServices<BookOrder, Integer> {

	protected final Logger LOG = LoggerFactory.getLogger(BookOrderServices.class);

	public BookOrder load(final Integer id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		BookOrder bookorder;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookOrderDAO bookorderDAO = new JpaBookOrderDAO();
			bookorder = bookorderDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return bookorder ;
	}

	public BookOrder save(final BookOrder entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		BookOrder entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookOrderDAO bookorderDAO = new JpaBookOrderDAO();
			entityNew = bookorderDAO.update(entity);
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
			JpaBookOrderDAO bookorderDAO = new JpaBookOrderDAO();
			bookorderDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<BookOrder> search(final BookOrder bookorder) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<BookOrder> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookOrderDAO bookorderDAO = new JpaBookOrderDAO();
			liste = bookorderDAO.search(bookorder);
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
