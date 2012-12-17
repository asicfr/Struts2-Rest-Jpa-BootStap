/*
 * Dto key class 
 * Created on 17 déc. 2012 ( Time 14:48:56 )
 */

package org.demo.bookorderitem.bean;

import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;

import javax.persistence.*;

@Embeddable
public class BookOrderItemKey implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="BOOK_ORDER_ID", nullable=false)
    private int        bookOrderId  ;
    
    @Column(name="BOOK_ID", nullable=false)
    private int        bookId       ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public BookOrderItemKey()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setBookOrderId( int value )
    {
        this.bookOrderId = value;
    }
    public int getBookOrderId()
    {
        return this.bookOrderId;
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
