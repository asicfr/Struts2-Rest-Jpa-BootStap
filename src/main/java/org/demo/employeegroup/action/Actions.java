/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */

package org.demo.employeegroup.action ;


import java.util.List;

import org.demo.employeegroup.bean.EmployeeGroup;
import org.demo.employeegroup.service.EmployeeGroupServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;
import org.demo.employeegroup.bean.EmployeeGroupKey;



public class Actions extends GenericAction<EmployeeGroup, EmployeeGroupKey>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<EmployeeGroup, EmployeeGroupKey> service = new EmployeeGroupServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<EmployeeGroup, EmployeeGroupKey> getServices() {
		return this.service;
	}
	
}

