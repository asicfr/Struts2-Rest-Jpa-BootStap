/*
 * Service class 
 * Created on 17 déc. 2012 ( Time 15:39:59 )
 */

package org.demo.badge.service;

import java.util.List;

import org.demo.badge.bean.Badge;
import org.demo.badge.dao.JpaBadgeDAO;
import org.telosys.starterkits.strutsjpa.EntityManagerHelper;
import org.telosys.starterkits.strutsjpa.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class BadgeServices implements IServices<Badge, Integer> {

	protected final Logger LOG = LoggerFactory.getLogger(BadgeServices.class);

	public Badge load(final Integer id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Badge badge;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBadgeDAO badgeDAO = new JpaBadgeDAO();
			badge = badgeDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return badge ;
	}

	public Badge save(final Badge entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Badge entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBadgeDAO badgeDAO = new JpaBadgeDAO();
			entityNew = badgeDAO.update(entity);
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
			JpaBadgeDAO badgeDAO = new JpaBadgeDAO();
			badgeDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Badge> search(final Badge badge) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Badge> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaBadgeDAO badgeDAO = new JpaBadgeDAO();
			liste = badgeDAO.search(badge);
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
