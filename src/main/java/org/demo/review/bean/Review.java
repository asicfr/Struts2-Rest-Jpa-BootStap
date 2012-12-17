/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 14:48:57 )
 */
// This Bean has a composite Primary Key  


package org.demo.review.bean;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="REVIEW", schema="ROOT" )
public class Review implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
	@EmbeddedId
    private ReviewKey key;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="REVIEW_TEXT")
    private String     reviewText   ;
    @Column(name="REVIEW_NOTE")
    private Integer    reviewNote   ;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATION")
    private Date       creation     ;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UPDATE")
    private Date       lastUpdate   ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Review()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------
    
	public ReviewKey getKey() {
        return key;
    }
 
    public void setKey(ReviewKey keyIn) {
        this.key = keyIn;
    }
    

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABSE MAPPING : REVIEW_TEXT ( LONG VARCHAR ) 
    public void setReviewText( String value )
    {
        this.reviewText = value;
    }
    public String getReviewText()
    {
        return this.reviewText;
    }

    //--- DATABSE MAPPING : REVIEW_NOTE ( INTEGER ) 
    public void setReviewNote( Integer value )
    {
        this.reviewNote = value;
    }
    public Integer getReviewNote()
    {
        return this.reviewNote;
    }

    //--- DATABSE MAPPING : CREATION ( TIMESTAMP ) 
    public void setCreation( Date value )
    {
        this.creation = value;
    }
    public Date getCreation()
    {
        return this.creation;
    }

    //--- DATABSE MAPPING : LAST_UPDATE ( TIMESTAMP ) 
    public void setLastUpdate( Date value )
    {
        this.lastUpdate = value;
    }
    public Date getLastUpdate()
    {
        return this.lastUpdate;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
