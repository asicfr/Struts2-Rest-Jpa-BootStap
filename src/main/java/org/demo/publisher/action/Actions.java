/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */

package org.demo.publisher.action ;


import java.util.List;

import org.demo.publisher.bean.Publisher;
import org.demo.publisher.service.PublisherServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Publisher, Integer>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Publisher, Integer> service = new PublisherServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Publisher, Integer> getServices() {
		return this.service;
	}
	
}

