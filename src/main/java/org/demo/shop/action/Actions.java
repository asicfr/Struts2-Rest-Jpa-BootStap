/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */

package org.demo.shop.action ;


import java.util.List;

import org.demo.shop.bean.Shop;
import org.demo.shop.service.ShopServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Shop, String>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Shop, String> service = new ShopServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Shop, String> getServices() {
		return this.service;
	}
	
}

