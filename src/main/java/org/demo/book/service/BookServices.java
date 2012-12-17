/*
 * Service class 
 * Created on 17 déc. 2012 ( Time 15:39:59 )
 */

package org.demo.book.service;

import java.util.List;

import org.demo.book.bean.Book;
import org.demo.book.dao.JpaBookDAO;
import org.telosys.starterkits.strutsjpa.EntityManagerHelper;
import org.telosys.starterkits.strutsjpa.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class BookServices implements IServices<Book, Integer> {

	protected final Logger LOG = LoggerFactory.getLogger(BookServices.class);

	public Book load(final Integer id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Book book;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookDAO bookDAO = new JpaBookDAO();
			book = bookDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return book ;
	}

	public Book save(final Book entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Book entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookDAO bookDAO = new JpaBookDAO();
			entityNew = bookDAO.update(entity);
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
			JpaBookDAO bookDAO = new JpaBookDAO();
			bookDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Book> search(final Book book) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Book> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBookDAO bookDAO = new JpaBookDAO();
			liste = bookDAO.search(book);
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
