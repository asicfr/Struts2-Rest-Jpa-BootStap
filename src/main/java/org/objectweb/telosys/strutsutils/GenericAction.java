package org.objectweb.telosys.strutsutils;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * @author slabbe
 * @param <T> Persistance bean type
 * @param <PK> Primary key type
 */
public abstract class GenericAction<T, PK> extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	public static final String RESULT_FORM = "form" ;
	public static final String RESULT_LIST = "list" ;
	
	protected final Logger LOG = LoggerFactory.getLogger(GenericAction.class);
	
	protected T current = null ;
	protected PK restid = null;
	protected List<T> searchResult = null ;


	@Override
	public void validate() {
		super.validate();
		if (this.hasFieldErrors()) {
			Set<Entry<String, List<String>>> entries = this.getFieldErrors().entrySet();
			for (Entry<String, List<String>> entry : entries) {
				for (String chaine : entry.getValue()) {
					LOG.error("Field error : " + chaine);
				}
			}
		}
		if (this.hasActionErrors()) {
			for (String chaine : this.getActionErrors()) {
				LOG.error("Action error : " + chaine);
			}
		}
	}

	/**
	 * Get Services
	 * @return Services
	 */
	protected abstract IServices<T, PK> getServices();

	/**
	 * Get restid
	 * @return restid
	 */
	public PK getRestid() {
		if (LOG.isDebugEnabled()) LOG.debug("getRestid");
		return restid;
	}

	/**
	 * Set restid
	 * @param id restid
	 */
	public void setRestid(final PK id) {
		if (LOG.isDebugEnabled()) LOG.debug("setRestid");
		this.restid = id;
	}

	/**
	 * Get current entity
	 * @return current entity
	 */
	public T getCurrent() {
		if (LOG.isDebugEnabled()) LOG.debug("getCurrent");
		return current;
	}

	/**
	 * Set current entity
	 * @param current entity
	 */
	public void setCurrent(final T current) {
		if (LOG.isDebugEnabled()) LOG.debug("setCurrent");
		this.current = current;
	}

	/**
	 * Get Search Result
	 * @return Search Result
	 */
	public List<T> getSearchResult() {
		if (LOG.isDebugEnabled()) LOG.debug("getSearchResult");
		return searchResult;
	}
	
	/**
	 * Load entity
	 * @return result key (see struts.xml)
	 * @throws Exception
	 */
	public String load() throws Exception {
		if (LOG.isDebugEnabled()) LOG.debug("Method 'load'");
		innerload();
		return RESULT_FORM ;
	}

	/**
	 * Delete entity
	 * @return result key (see struts.xml)
	 * @throws Exception
	 */
	public String delete() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Method 'delete'");
			LOG.debug("Id send : " + restid );
		}
		getServices().delete(restid);
		addActionMessage(getText("entity.delete"));
		return RESULT_FORM ;
	}

	/**
	 * Save entity
	 * @return result key (see struts.xml)
	 * @throws Exception
	 */
	public String save() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Method 'save'");
			LOG.debug("Form values : " + current );
		}

		if (current != null) {
			this.current = getServices().save(current);
			addActionMessage(getText("entity.save"));
		} else {
			addActionError(getText("entity.nothing.to.save"));
		}
		return RESULT_FORM ;
	}

	/**
	 * Search for entities
	 * @return result key (see struts.xml)
	 * @throws Exception
	 */
	public String search() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Method 'search'");
			LOG.debug("Form values : " + current );
		}
		
		searchResult = getServices().search( current );
		if (LOG.isDebugEnabled()) LOG.debug("After SEARCH : count = " + searchResult.size() );
		if ( searchResult.size() > 1 ) {
			final String[] args = {Integer.toString(searchResult.size())};
			final String text = getText("entity.found.many", args);
			addActionMessage(text);
			return RESULT_LIST ;
		}
		else if ( searchResult.size() == 1 ) {
			current = searchResult.get(0);
			addActionMessage(getText("entity.found.one"));
			return RESULT_FORM ;
		}
		else {
			addActionMessage(getText("entity.nothing.found"));
			return RESULT_FORM ;
		}
	}

	/**
	 * Clear data form
	 * @return result key (see struts.xml)
	 */
	public String clear() {
		if (LOG.isDebugEnabled()) LOG.debug("Method 'clear'");
		this.current = null;
		this.restid = null;
		this.searchResult = null;
		return RESULT_FORM ;
	}

	/**
	 * Load entity
	 * @throws Exception
	 */
	protected void innerload() throws Exception {
		this.current = getServices().load(restid);
		if ( this.current != null ) {
			addActionMessage(getText("entity.found"));
		} else {
			addActionError(getText("entity.not.found"));
		}
	}


}
