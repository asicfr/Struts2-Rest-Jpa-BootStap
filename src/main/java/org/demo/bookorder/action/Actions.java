/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:25 )
 */

package org.demo.bookorder.action ;


import java.util.List;

import org.demo.bookorder.bean.BookOrder;
import org.demo.bookorder.service.BookOrderServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<BookOrder, Integer>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<BookOrder, Integer> service = new BookOrderServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<BookOrder, Integer> getServices() {
		return this.service;
	}
	
}

