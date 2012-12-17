/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 15:39:59 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.book.bean;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="BOOK", schema="ROOT" )
public class Book implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID", nullable=false)
    private int        id           ;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="PUBLISHER_ID", nullable=false)
    private int        publisherId  ;
    @Column(name="AUTHOR_ID", nullable=false)
    private int        authorId     ;
    @Column(name="ISBN", nullable=false, length=13)
    private String     isbn         ;
    @Column(name="TITLE", length=160)
    private String     title        ;
    @Column(name="PRICE")
    private BigDecimal price        ;
    @Column(name="QUANTITY")
    private Integer    quantity     ;
    @Column(name="DISCOUNT")
    private Integer    discount     ;
    @Column(name="AVAILABILITY")
    private Short      availability ;
    @Column(name="BEST_SELLER")
    private Short      bestSeller   ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Book()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( int value )
    {
        this.id = value;
    }
    public int getId()
    {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABSE MAPPING : PUBLISHER_ID ( INTEGER ) 
    public void setPublisherId( int value )
    {
        this.publisherId = value;
    }
    public int getPublisherId()
    {
        return this.publisherId;
    }

    //--- DATABSE MAPPING : AUTHOR_ID ( INTEGER ) 
    public void setAuthorId( int value )
    {
        this.authorId = value;
    }
    public int getAuthorId()
    {
        return this.authorId;
    }

    //--- DATABSE MAPPING : ISBN ( VARCHAR ) 
    public void setIsbn( String value )
    {
        this.isbn = value;
    }
    public String getIsbn()
    {
        return this.isbn;
    }

    //--- DATABSE MAPPING : TITLE ( VARCHAR ) 
    public void setTitle( String value )
    {
        this.title = value;
    }
    public String getTitle()
    {
        return this.title;
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

    //--- DATABSE MAPPING : QUANTITY ( INTEGER ) 
    public void setQuantity( Integer value )
    {
        this.quantity = value;
    }
    public Integer getQuantity()
    {
        return this.quantity;
    }

    //--- DATABSE MAPPING : DISCOUNT ( INTEGER ) 
    public void setDiscount( Integer value )
    {
        this.discount = value;
    }
    public Integer getDiscount()
    {
        return this.discount;
    }

    //--- DATABSE MAPPING : AVAILABILITY ( SMALLINT ) 
    public void setAvailability( Short value )
    {
        this.availability = value;
    }
    public Short getAvailability()
    {
        return this.availability;
    }

    //--- DATABSE MAPPING : BEST_SELLER ( SMALLINT ) 
    public void setBestSeller( Short value )
    {
        this.bestSeller = value;
    }
    public Short getBestSeller()
    {
        return this.bestSeller;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
