/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */

package org.demo.country.action ;


import java.util.List;

import org.demo.country.bean.Country;
import org.demo.country.service.CountryServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Country, String>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Country, String> service = new CountryServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Country, String> getServices() {
		return this.service;
	}
	
}

