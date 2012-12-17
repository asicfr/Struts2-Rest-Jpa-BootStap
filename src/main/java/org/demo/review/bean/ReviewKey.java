/*
 * Dto key class 
 * Created on 17 déc. 2012 ( Time 14:48:57 )
 */

package org.demo.review.bean;

import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

@Embeddable
public class ReviewKey implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="CUSTOMER_CODE", nullable=false, length=5)
    private String     customerCode ;
    
    @Column(name="BOOK_ID", nullable=false)
    private int        bookId       ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ReviewKey()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setCustomerCode( String value )
    {
        this.customerCode = value;
    }
    public String getCustomerCode()
    {
        return this.customerCode;
    }

    public void setBookId( int value )
    {
        this.bookId = value;
    }
    public int getBookId()
    {
        return this.bookId;
    }


    

}
