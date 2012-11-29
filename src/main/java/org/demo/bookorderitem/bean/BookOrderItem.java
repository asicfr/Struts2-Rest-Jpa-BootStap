/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:25 )
 */

package org.demo.bookorderitem.bean ;


import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="BOOK_ORDER_ITEM", schema="ROOT" )
public class BookOrderItem implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    
	@EmbeddedId
    private BookOrderItemKey key;

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR ENTITY KEY FIELDS
    //----------------------------------------------------------------------
    
	public BookOrderItemKey getKey() {
        return key;
    }
 
    public void setKey(BookOrderItemKey keyIn) {
        this.key = keyIn;
    }
    
    //----------------------------------------------------------------------
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Column(name="QUANTITY", nullable=false)
    private int        quantity     ;
    @Column(name="PRICE", nullable=false)
    private BigDecimal price        ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public BookOrderItem()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------
    //--- DB COLUMN : QUANTITY ( INTEGER ) 
    public void setQuantity( int value )
    {
        this.quantity = value;
    }
    public int getQuantity()
    {
        return this.quantity;
    }

    //--- DB COLUMN : PRICE ( DECIMAL ) 
    public void setPrice( BigDecimal value )
    {
        this.price = value;
    }
    public BigDecimal getPrice()
    {
        return this.price;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
