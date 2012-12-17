/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 14:48:57 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.synopsis.bean;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

@Entity
@Table(name="SYNOPSIS", schema="ROOT" )
public class Synopsis implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="BOOK_ID", nullable=false)
    private int        bookId       ;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="SYNOPSIS")
    private String     synopsis     ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Synopsis()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setBookId( int value )
    {
        this.bookId = value;
    }
    public int getBookId()
    {
        return this.bookId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABSE MAPPING : SYNOPSIS ( LONG VARCHAR ) 
    public void setSynopsis( String value )
    {
        this.synopsis = value;
    }
    public String getSynopsis()
    {
        return this.synopsis;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
