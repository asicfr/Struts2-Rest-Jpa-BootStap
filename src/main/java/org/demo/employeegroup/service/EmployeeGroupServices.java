/*
 * Service class 
 * Created on 17 déc. 2012 ( Time 14:48:56 )
 */

package org.demo.employeegroup.service;

import java.util.List;

import org.demo.employeegroup.bean.EmployeeGroup;
import org.demo.employeegroup.dao.JpaEmployeeGroupDAO;
import org.telosys.starterkits.strutsjpa.EntityManagerHelper;
import org.telosys.starterkits.strutsjpa.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import org.demo.employeegroup.bean.EmployeeGroupKey;

public class EmployeeGroupServices implements IServices<EmployeeGroup, EmployeeGroupKey> {

	protected final Logger LOG = LoggerFactory.getLogger(EmployeeGroupServices.class);

	public EmployeeGroup load(final EmployeeGroupKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		EmployeeGroup employeegroup;
		try {
			EntityManagerHelper.beginTransaction();
			JpaEmployeeGroupDAO employeegroupDAO = new JpaEmployeeGroupDAO();
			employeegroup = employeegroupDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return employeegroup ;
	}

	public EmployeeGroup save(final EmployeeGroup entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		EmployeeGroup entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaEmployeeGroupDAO employeegroupDAO = new JpaEmployeeGroupDAO();
			entityNew = employeegroupDAO.update(entity);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return entityNew;
	}

	public void delete(final EmployeeGroupKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("delete");
		try {
			EntityManagerHelper.beginTransaction();
			JpaEmployeeGroupDAO employeegroupDAO = new JpaEmployeeGroupDAO();
			employeegroupDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<EmployeeGroup> search(final EmployeeGroup employeegroup) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<EmployeeGroup> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaEmployeeGroupDAO employeegroupDAO = new JpaEmployeeGroupDAO();
			liste = employeegroupDAO.search(employeegroup);
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
