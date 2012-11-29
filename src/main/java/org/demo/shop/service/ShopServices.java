/*
 * Service class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */

package org.demo.shop.service ;

import java.util.List;

import org.demo.shop.bean.Shop;
import org.demo.shop.dao.JpaShopDAO;
import org.objectweb.telosys.strutsutils.EntityManagerHelper;
import org.objectweb.telosys.strutsutils.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class ShopServices implements IServices<Shop, String> {

	protected final Logger LOG = LoggerFactory.getLogger(ShopServices.class);

	public Shop load(final String id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Shop shop;
		try {
			EntityManagerHelper.beginTransaction();
			JpaShopDAO shopDAO = new JpaShopDAO();
			shop = shopDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return shop ;
	}

	public Shop save(final Shop entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Shop entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaShopDAO shopDAO = new JpaShopDAO();
			entityNew = shopDAO.update(entity);
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
			JpaShopDAO shopDAO = new JpaShopDAO();
			shopDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Shop> search(final Shop shop) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Shop> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaShopDAO shopDAO = new JpaShopDAO();
			liste = shopDAO.search(shop);
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
