/*
 * Service class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */

package org.demo.employee.service ;

import java.util.List;

import org.demo.employee.bean.Employee;
import org.demo.employee.dao.JpaEmployeeDAO;
import org.objectweb.telosys.strutsutils.EntityManagerHelper;
import org.objectweb.telosys.strutsutils.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;


public class EmployeeServices implements IServices<Employee, String> {

	protected final Logger LOG = LoggerFactory.getLogger(EmployeeServices.class);

	public Employee load(final String id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Employee employee;
		try {
			EntityManagerHelper.beginTransaction();
			JpaEmployeeDAO employeeDAO = new JpaEmployeeDAO();
			employee = employeeDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return employee ;
	}

	public Employee save(final Employee entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Employee entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaEmployeeDAO employeeDAO = new JpaEmployeeDAO();
			entityNew = employeeDAO.update(entity);
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
			JpaEmployeeDAO employeeDAO = new JpaEmployeeDAO();
			employeeDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Employee> search(final Employee employee) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Employee> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaEmployeeDAO employeeDAO = new JpaEmployeeDAO();
			liste = employeeDAO.search(employee);
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
