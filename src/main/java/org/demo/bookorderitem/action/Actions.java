/*
 * Action class 
 * Created on 17 déc. 2012 ( Time 15:39:59 )
 */

package org.demo.bookorderitem.action;

import org.demo.bookorderitem.bean.BookOrderItem;
import org.demo.bookorderitem.service.BookOrderItemServices;
import org.telosys.starterkits.strutsjpa.GenericAction;
import org.telosys.starterkits.strutsjpa.IServices;

import org.demo.bookorderitem.bean.BookOrderItemKey;

public class Actions extends GenericAction<BookOrderItem, BookOrderItemKey>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<BookOrderItem, BookOrderItemKey> service = new BookOrderItemServices();

	private BookOrderItem current = null ;
	private BookOrderItemKey restid = null;
	
	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<BookOrderItem, BookOrderItemKey> getServices() {
		return this.service;
	}
	
	/**
	 * Get current entity
	 * @return current entity
	 */
	public BookOrderItem getCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	/**
	 * Set current entity
	 * @param currentIn entity
	 */
	public void setCurrent(final BookOrderItem currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}

	/**
	 * Get restid
	 * @return restid
	 */
	public BookOrderItemKey getRestid() {
		if (LOG.isDebugEnabled()) LOG.debug("getRestid");
		return restid;
	}

	/**
	 * Set restid
	 * @param id restid
	 */
	public void setRestid(final BookOrderItemKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("setRestid");
		this.restid = id;
	}

	@Override
	protected BookOrderItem getInnerCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	@Override
	protected void setInnerCurrent(final BookOrderItem currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}

	@Override
	protected BookOrderItemKey getInnerRestid() {
		if (LOG.isDebugEnabled()) LOG.debug("getInnerRestid");
		return this.restid;
	}

	@Override
	protected void setInnerRestid(final BookOrderItemKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("setInnerRestid");
		this.restid = id;
	}
	
}

