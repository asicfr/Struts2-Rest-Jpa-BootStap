/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:24 )
 */
package org.demo.book.bean;


import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

@Entity
@Table(name="BOOK", schema="ROOT" )
public class Book implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    //----------------------------------------------------------------------
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID", nullable=false)
    private Integer    id           ;
    @Column(name="PUBLISHER_ID", nullable=false)
    private Integer    publisherId  ;
    @Column(name="AUTHOR_ID", nullable=false)
    private Integer    authorId     ;
    @Column(name="ISBN", nullable=false, length=13)
    private String     isbn         ;
    @Column(name="TITLE", length=160)
    private String     title        ;
    @Column(name="PRICE")
    private Double     price        ;
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
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------
    //--- DB PRIMARY KEY : ID ( INTEGER ) 
    public void setId( Integer value )
    {
        this.id = value;
    }
    public Integer getId()
    {
        return this.id;
    }

    //--- DB COLUMN : PUBLISHER_ID ( INTEGER ) 
    public void setPublisherId( Integer value )
    {
        this.publisherId = value;
    }
    public Integer getPublisherId()
    {
        return this.publisherId;
    }

    //--- DB COLUMN : AUTHOR_ID ( INTEGER ) 
    public void setAuthorId( Integer value )
    {
        this.authorId = value;
    }
    public Integer getAuthorId()
    {
        return this.authorId;
    }

    //--- DB COLUMN : ISBN ( VARCHAR ) 
    public void setIsbn( String value )
    {
        this.isbn = value;
    }
    public String getIsbn()
    {
        return this.isbn;
    }

    //--- DB COLUMN : TITLE ( VARCHAR ) 
    public void setTitle( String value )
    {
        this.title = value;
    }
    public String getTitle()
    {
        return this.title;
    }

    //--- DB COLUMN : PRICE ( DECIMAL ) 
    public void setPrice( Double value )
    {
        this.price = value;
    }
    public Double getPrice()
    {
        return this.price;
    }

    //--- DB COLUMN : QUANTITY ( INTEGER ) 
    public void setQuantity( Integer value )
    {
        this.quantity = value;
    }
    public Integer getQuantity()
    {
        return this.quantity;
    }

    //--- DB COLUMN : DISCOUNT ( INTEGER ) 
    public void setDiscount( Integer value )
    {
        this.discount = value;
    }
    public Integer getDiscount()
    {
        return this.discount;
    }

    //--- DB COLUMN : AVAILABILITY ( SMALLINT ) 
    public void setAvailability( Short value )
    {
        this.availability = value;
    }
    public Short getAvailability()
    {
        return this.availability;
    }

    //--- DB COLUMN : BEST_SELLER ( SMALLINT ) 
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
