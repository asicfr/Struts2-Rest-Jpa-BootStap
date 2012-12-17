/*
 * Action class 
 * Created on 17 déc. 2012 ( Time 15:40:01 )
 */

package org.demo.workgroup.action;

import org.demo.workgroup.bean.Workgroup;
import org.demo.workgroup.service.WorkgroupServices;
import org.telosys.starterkits.strutsjpa.GenericAction;
import org.telosys.starterkits.strutsjpa.IServices;


public class Actions extends GenericAction<Workgroup, Short>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Workgroup, Short> service = new WorkgroupServices();

	private Workgroup current = null ;
	private Short restid = null;
	
	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Workgroup, Short> getServices() {
		return this.service;
	}
	
	/**
	 * Get current entity
	 * @return current entity
	 */
	public Workgroup getCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	/**
	 * Set current entity
	 * @param currentIn entity
	 */
	public void setCurrent(final Workgroup currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}

	/**
	 * Get restid
	 * @return restid
	 */
	public Short getRestid() {
		if (LOG.isDebugEnabled()) LOG.debug("getRestid");
		return restid;
	}

	/**
	 * Set restid
	 * @param id restid
	 */
	public void setRestid(final Short id) {
		if (LOG.isDebugEnabled()) LOG.debug("setRestid");
		this.restid = id;
	}

	@Override
	protected Workgroup getInnerCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	@Override
	protected void setInnerCurrent(final Workgroup currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}

	@Override
	protected Short getInnerRestid() {
		if (LOG.isDebugEnabled()) LOG.debug("getInnerRestid");
		return this.restid;
	}

	@Override
	protected void setInnerRestid(final Short id) {
		if (LOG.isDebugEnabled()) LOG.debug("setInnerRestid");
		this.restid = id;
	}
	
}

