/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:25 )
 */

package org.demo.author.action ;


import java.util.List;

import org.demo.author.bean.Author;
import org.demo.author.service.AuthorServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Author, Integer>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Author, Integer> service = new AuthorServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Author, Integer> getServices() {
		return this.service;
	}
	
}

