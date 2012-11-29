/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */

package org.demo.synopsis.action ;


import java.util.List;

import org.demo.synopsis.bean.Synopsis;
import org.demo.synopsis.service.SynopsisServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Synopsis, Integer>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Synopsis, Integer> service = new SynopsisServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Synopsis, Integer> getServices() {
		return this.service;
	}
	
}

