/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */

package org.demo.employee.action ;


import java.util.List;

import org.demo.employee.bean.Employee;
import org.demo.employee.service.EmployeeServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Employee, String>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Employee, String> service = new EmployeeServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Employee, String> getServices() {
		return this.service;
	}
	
}

