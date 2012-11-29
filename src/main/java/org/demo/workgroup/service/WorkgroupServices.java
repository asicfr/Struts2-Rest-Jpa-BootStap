/*
 * Service class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */

package org.demo.workgroup.service ;

import java.util.List;

import org.demo.workgroup.bean.Workgroup;
import org.demo.workgroup.dao.JpaWorkgroupDAO;
import org.objectweb.telosys.strutsutils.EntityManagerHelper;
import org.objectweb.telosys.strutsutils.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class WorkgroupServices implements IServices<Workgroup, Short> {

	protected final Logger LOG = LoggerFactory.getLogger(WorkgroupServices.class);

	public Workgroup load(final Short id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Workgroup workgroup;
		try {
			EntityManagerHelper.beginTransaction();
			JpaWorkgroupDAO workgroupDAO = new JpaWorkgroupDAO();
			workgroup = workgroupDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return workgroup ;
	}

	public Workgroup save(final Workgroup entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Workgroup entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaWorkgroupDAO workgroupDAO = new JpaWorkgroupDAO();
			entityNew = workgroupDAO.update(entity);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return entityNew;
	}

	public void delete(final Short id) {
		if (LOG.isDebugEnabled()) LOG.debug("delete");
		try {
			EntityManagerHelper.beginTransaction();
			JpaWorkgroupDAO workgroupDAO = new JpaWorkgroupDAO();
			workgroupDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Workgroup> search(final Workgroup workgroup) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Workgroup> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaWorkgroupDAO workgroupDAO = new JpaWorkgroupDAO();
			liste = workgroupDAO.search(workgroup);
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
