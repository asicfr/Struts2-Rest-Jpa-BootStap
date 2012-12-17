/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 15:39:59 )
 */
// This Bean has a composite Primary Key  


package org.demo.bookorderitem.bean;

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
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
	@EmbeddedId
    private BookOrderItemKey key;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
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
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------
    
	public BookOrderItemKey getKey() {
        return key;
    }
 
    public void setKey(BookOrderItemKey keyIn) {
        this.key = keyIn;
    }
    

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABSE MAPPING : QUANTITY ( INTEGER ) 
    public void setQuantity( int value )
    {
        this.quantity = value;
    }
    public int getQuantity()
    {
        return this.quantity;
    }

    //--- DATABSE MAPPING : PRICE ( DECIMAL ) 
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
