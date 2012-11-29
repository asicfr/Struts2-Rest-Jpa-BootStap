/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */
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
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Id
    @Column(name="BOOK_ID", nullable=false)
    private int        bookId       ;
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
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------
    //--- DB PRIMARY KEY : BOOK_ID ( INTEGER ) 
    public void setBookId( int value )
    {
        this.bookId = value;
    }
    public int getBookId()
    {
        return this.bookId;
    }

    //--- DB COLUMN : SYNOPSIS ( LONG VARCHAR ) 
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
