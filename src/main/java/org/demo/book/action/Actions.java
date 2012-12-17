/*
 * Action class 
 * Created on 17 déc. 2012 ( Time 15:39:59 )
 */

package org.demo.book.action;

import org.demo.book.bean.Book;
import org.demo.book.service.BookServices;
import org.telosys.starterkits.strutsjpa.GenericAction;
import org.telosys.starterkits.strutsjpa.IServices;


public class Actions extends GenericAction<Book, Integer>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Book, Integer> service = new BookServices();

	private Book current = null ;
	private Integer restid = null;
	
	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Book, Integer> getServices() {
		return this.service;
	}
	
	/**
	 * Get current entity
	 * @return current entity
	 */
	public Book getCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	/**
	 * Set current entity
	 * @param currentIn entity
	 */
	public void setCurrent(final Book currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}

	/**
	 * Get restid
	 * @return restid
	 */
	public Integer getRestid() {
		if (LOG.isDebugEnabled()) LOG.debug("getRestid");
		return restid;
	}

	/**
	 * Set restid
	 * @param id restid
	 */
	public void setRestid(final Integer id) {
		if (LOG.isDebugEnabled()) LOG.debug("setRestid");
		this.restid = id;
	}

	@Override
	protected Book getInnerCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	@Override
	protected void setInnerCurrent(final Book currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}

	@Override
	protected Integer getInnerRestid() {
		if (LOG.isDebugEnabled()) LOG.debug("getInnerRestid");
		return this.restid;
	}

	@Override
	protected void setInnerRestid(final Integer id) {
		if (LOG.isDebugEnabled()) LOG.debug("setInnerRestid");
		this.restid = id;
	}
	
}

