/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */

package org.demo.bookorderitem.action ;


import java.util.List;

import org.demo.bookorderitem.bean.BookOrderItem;
import org.demo.bookorderitem.service.BookOrderItemServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;
import org.demo.bookorderitem.bean.BookOrderItemKey;



public class Actions extends GenericAction<BookOrderItem, BookOrderItemKey>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<BookOrderItem, BookOrderItemKey> service = new BookOrderItemServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<BookOrderItem, BookOrderItemKey> getServices() {
		return this.service;
	}
	
}

