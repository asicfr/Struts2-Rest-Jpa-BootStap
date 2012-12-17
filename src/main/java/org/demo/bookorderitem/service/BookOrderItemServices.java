/*
 * Service class 
 * Created on 17 déc. 2012 ( Time 15:39:59 )
 */

package org.demo.bookorderitem.service;

import java.util.List;

import org.demo.bookorderitem.bean.BookOrderItem;
import org.demo.bookorderitem.dao.JpaBookOrderItemDAO;
import org.telosys.starterkits.strutsjpa.EntityManagerHelper;
import org.telosys.starterkits.strutsjpa.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import org.demo.bookorderitem.bean.BookOrderItemKey;

public class BookOrderItemServices implements IServices<BookOrderItem, BookOrderItemKey> {

	protected final Logger LOG = LoggerFactory.getLogger(BookOrderItemServices.class);

	public BookOrderItem load(final BookOrderItemKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		BookOrderItem bookorderitem;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookOrderItemDAO bookorderitemDAO = new JpaBookOrderItemDAO();
			bookorderitem = bookorderitemDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return bookorderitem ;
	}

	public BookOrderItem save(final BookOrderItem entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		BookOrderItem entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookOrderItemDAO bookorderitemDAO = new JpaBookOrderItemDAO();
			entityNew = bookorderitemDAO.update(entity);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return entityNew;
	}

	public void delete(final BookOrderItemKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("delete");
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookOrderItemDAO bookorderitemDAO = new JpaBookOrderItemDAO();
			bookorderitemDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<BookOrderItem> search(final BookOrderItem bookorderitem) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<BookOrderItem> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookOrderItemDAO bookorderitemDAO = new JpaBookOrderItemDAO();
			liste = bookorderitemDAO.search(bookorderitem);
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
