/*
 * Action class 
 * Created on 17 déc. 2012 ( Time 15:40:00 )
 */

package org.demo.review.action;

import org.demo.review.bean.Review;
import org.demo.review.service.ReviewServices;
import org.telosys.starterkits.strutsjpa.GenericAction;
import org.telosys.starterkits.strutsjpa.IServices;

import org.demo.review.bean.ReviewKey;

public class Actions extends GenericAction<Review, ReviewKey>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Review, ReviewKey> service = new ReviewServices();

	private Review current = null ;
	private ReviewKey restid = null;
	
	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Review, ReviewKey> getServices() {
		return this.service;
	}
	
	/**
	 * Get current entity
	 * @return current entity
	 */
	public Review getCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	/**
	 * Set current entity
	 * @param currentIn entity
	 */
	public void setCurrent(final Review currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}

	/**
	 * Get restid
	 * @return restid
	 */
	public ReviewKey getRestid() {
		if (LOG.isDebugEnabled()) LOG.debug("getRestid");
		return restid;
	}

	/**
	 * Set restid
	 * @param id restid
	 */
	public void setRestid(final ReviewKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("setRestid");
		this.restid = id;
	}

	@Override
	protected Review getInnerCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return this.current;
	}

	@Override
	protected void setInnerCurrent(final Review currentIn) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = currentIn;
	}

	@Override
	protected ReviewKey getInnerRestid() {
		if (LOG.isDebugEnabled()) LOG.debug("getInnerRestid");
		return this.restid;
	}

	@Override
	protected void setInnerRestid(final ReviewKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("setInnerRestid");
		this.restid = id;
	}
	
}

