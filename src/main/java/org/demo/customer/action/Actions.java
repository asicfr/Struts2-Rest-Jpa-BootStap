/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */

package org.demo.customer.action ;


import java.util.List;

import org.demo.customer.bean.Customer;
import org.demo.customer.service.CustomerServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Customer, String>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Customer, String> service = new CustomerServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Customer, String> getServices() {
		return this.service;
	}
	
}

