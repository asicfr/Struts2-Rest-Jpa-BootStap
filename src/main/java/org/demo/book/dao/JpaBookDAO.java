/*
 * Dao class 
 * Created on 29 nov. 2012 ( Time 10:46:25 )
 */

package org.demo.book.dao ;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.demo.book.bean.Book;
import org.objectweb.telosys.strutsutils.CoreUtils;
import org.objectweb.telosys.strutsutils.GenericJpaDao;




public class JpaBookDAO extends GenericJpaDao<Book, Integer> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for Book
	 */
	public JpaBookDAO() {
		super(Book.class);
	}
	
	/**
	 * Search by Book example
	 */
	public List<Book> search(final Book element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
			Root<Book> from = criteriaQuery.from(Book.class);

			List<Predicate> listP = new ArrayList<Predicate>();

			if (CoreUtils.isNotBlank(element.getId())) {
				Predicate predicate = criteriaBuilder.equal(from.get("id"), element.getId());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getPublisherId())) {
				Predicate predicate = criteriaBuilder.equal(from.get("publisherId"), element.getPublisherId());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getAuthorId())) {
				Predicate predicate = criteriaBuilder.equal(from.get("authorId"), element.getAuthorId());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getIsbn())) {
				Predicate predicate = criteriaBuilder.equal(from.get("isbn"), element.getIsbn());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getTitle())) {
				Predicate predicate = criteriaBuilder.equal(from.get("title"), element.getTitle());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getPrice())) {
				Predicate predicate = criteriaBuilder.equal(from.get("price"), element.getPrice());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getQuantity())) {
				Predicate predicate = criteriaBuilder.equal(from.get("quantity"), element.getQuantity());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getDiscount())) {
				Predicate predicate = criteriaBuilder.equal(from.get("discount"), element.getDiscount());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getAvailability())) {
				Predicate predicate = criteriaBuilder.equal(from.get("availability"), element.getAvailability());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getBestSeller())) {
				Predicate predicate = criteriaBuilder.equal(from.get("bestSeller"), element.getBestSeller());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<Book> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}