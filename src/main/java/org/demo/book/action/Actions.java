/*
 * Action class 
 * Created on 29 nov. 2012 ( Time 10:46:25 )
 */

package org.demo.book.action ;


import java.util.List;

import org.demo.book.bean.Book;
import org.demo.book.service.BookServices;
import org.objectweb.telosys.strutsutils.GenericAction;
import org.objectweb.telosys.strutsutils.IServices;




public class Actions extends GenericAction<Book, Integer>
{
	private static final long serialVersionUID = 1L;
	
	private IServices<Book, Integer> service = new BookServices();

	public Actions() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("=== ACTION CONSTRUCTOR");
		}
	}

	/*
	 * @see org.demo.action.GenericAction#getServices()
	 */
	protected IServices<Book, Integer> getServices() {
		return this.service;
	}
	
}

