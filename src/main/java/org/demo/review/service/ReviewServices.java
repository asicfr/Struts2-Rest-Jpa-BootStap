/*
 * Service class 
 * Created on 29 nov. 2012 ( Time 10:46:24 )
 */

package org.demo.review.service ;

import java.util.List;

import org.demo.review.bean.Review;
import org.demo.review.dao.JpaReviewDAO;
import org.objectweb.telosys.strutsutils.EntityManagerHelper;
import org.objectweb.telosys.strutsutils.IServices;
import javax.persistence.PersistenceException;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import org.demo.review.bean.ReviewKey;
	
public class ReviewServices implements IServices<Review, ReviewKey> {

	protected final Logger LOG = LoggerFactory.getLogger(ReviewServices.class);

	public Review load(final ReviewKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("load");
		Review review;
		try {
			EntityManagerHelper.beginTransaction();
			JpaReviewDAO reviewDAO = new JpaReviewDAO();
			review = reviewDAO.findById(id);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return review ;
	}

	public Review save(final Review entity) {
		if (LOG.isDebugEnabled()) LOG.debug("save");
		Review entityNew;
		try {
			EntityManagerHelper.beginTransaction();
			JpaReviewDAO reviewDAO = new JpaReviewDAO();
			entityNew = reviewDAO.update(entity);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return entityNew;
	}

	public void delete(final ReviewKey id) {
		if (LOG.isDebugEnabled()) LOG.debug("delete");
		try {
			EntityManagerHelper.beginTransaction();
			JpaReviewDAO reviewDAO = new JpaReviewDAO();
			reviewDAO.delete(id);
			EntityManagerHelper.commitAndCloseEntityManager();	
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
	}

	public List<Review> search(final Review review) {
		if (LOG.isDebugEnabled()) LOG.debug("search");
		List<Review> liste;
		try {
			EntityManagerHelper.beginTransaction();
			JpaReviewDAO reviewDAO = new JpaReviewDAO();
			liste = reviewDAO.search(review);
			EntityManagerHelper.commitAndCloseEntityManager();
		} catch (PersistenceException ex) {
			LOG.error("Error", ex);
			throw ex;
		} finally {
			if (EntityManagerHelper.isCloseEntityManager() == false) EntityManagerHelper.rollback();
		}
		return liste;
	}

}
