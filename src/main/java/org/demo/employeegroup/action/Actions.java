/*
 * Action class 
 * Created on 17 déc. 2012 ( Time 14:48:56 )
 */

package org.demo.employeegroup.action;

import org.demo.employeegroup.bean.EmployeeGroup;
import org.demo.employeegroup.service.EmployeeGroupServices;
import org.telosys.starterkits.strutsjpa.GenericAction;
import org.telosys.starterkits.strutsjpa.IServices;

import org.demo.employeegroup.bean.EmployeeGroupKey;

public class Actions extends GenericAction<EmployeeGroup, EmployeeGroupKey>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<EmployeeGroup, EmployeeGroupKey> service = new EmployeeGroupServices();

	private EmployeeGroup current = null ;
	
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
	
	/**
	 * Get current entity
	 * @return current entity
	 */
	public EmployeeGroup getCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	/**
	 * Set current entity
	 * @param currentIn entity
	 */
	public void setCurrent(final EmployeeGroup currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}

	@Override
	protected EmployeeGroup getInnerCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	@Override
	protected void setInnerCurrent(final EmployeeGroup currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}
	
}

