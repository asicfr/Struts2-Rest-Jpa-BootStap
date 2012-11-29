/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:24 )
 */

package org.demo.review.action ;


import java.util.List;

import org.demo.review.bean.Review;
import org.demo.review.service.ReviewServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;
import org.demo.review.bean.ReviewKey;



public class Actions extends GenericAction<Review, ReviewKey>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Review, ReviewKey> service = new ReviewServices();

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
	
}

