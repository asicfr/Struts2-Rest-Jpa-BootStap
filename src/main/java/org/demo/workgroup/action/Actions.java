/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */

package org.demo.workgroup.action ;


import java.util.List;

import org.demo.workgroup.bean.Workgroup;
import org.demo.workgroup.service.WorkgroupServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Workgroup, Short>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Workgroup, Short> service = new WorkgroupServices();

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
	
}

