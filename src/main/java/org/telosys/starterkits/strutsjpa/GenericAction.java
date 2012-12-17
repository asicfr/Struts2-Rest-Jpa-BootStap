package org.telosys.starterkits.strutsjpa;

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
	
	protected PK restid = null;
	protected List<T> searchResult = null ;
	protected abstract IServices<T, PK> getServices();
	protected abstract T getInnerCurrent();
	protected abstract void setInnerCurrent(T t);

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
			LOG.debug("Form values : " + this.getInnerCurrent() );
		}

		if (getInnerCurrent() != null) {
			this.setInnerCurrent(getServices().save(this.getInnerCurrent()));
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
			LOG.debug("Form values : " + this.getInnerCurrent() );
		}
		
		searchResult = getServices().search( this.getInnerCurrent() );
		if (LOG.isDebugEnabled()) LOG.debug("After SEARCH : count = " + searchResult.size() );
		if ( searchResult.size() > 1 ) {
			final String[] args = {Integer.toString(searchResult.size())};
			final String text = getText("entity.found.many", args);
			addActionMessage(text);
			return RESULT_LIST ;
		}
		else if ( searchResult.size() == 1 ) {
			this.setInnerCurrent(searchResult.get(0));
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
		this.setInnerCurrent(null);
		this.restid = null;
		this.searchResult = null;
		return RESULT_FORM ;
	}

	/**
	 * Load entity
	 * @throws Exception
	 */
	protected void innerload() throws Exception {
		this.setInnerCurrent(getServices().load(restid));
		if ( this.getInnerCurrent() != null ) {
			addActionMessage(getText("entity.found"));
		} else {
			addActionError(getText("entity.not.found"));
		}
	}

}
