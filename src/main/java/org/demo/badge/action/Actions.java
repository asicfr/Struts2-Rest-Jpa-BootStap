/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:25 )
 */

package org.demo.badge.action ;


import java.util.List;

import org.demo.badge.bean.Badge;
import org.demo.badge.service.BadgeServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Badge, Integer>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Badge, Integer> service = new BadgeServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Badge, Integer> getServices() {
		return this.service;
	}
	
}

