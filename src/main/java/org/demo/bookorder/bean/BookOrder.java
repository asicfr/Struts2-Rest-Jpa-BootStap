/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:25 )
 */
package org.demo.bookorder.bean;


import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="BOOK_ORDER", schema="ROOT" )
public class BookOrder implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    //----------------------------------------------------------------------
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID", nullable=false)
    private int        id           ;
    @Column(name="SHOP_CODE", nullable=false, length=3)
    private String     shopCode     ;
    @Column(name="CUSTOMER_CODE", nullable=false, length=5)
    private String     customerCode ;
    @Column(name="EMPLOYEE_CODE", nullable=false, length=4)
    private String     employeeCode ;
    @Temporal(TemporalType.DATE)
    @Column(name="DATE")
    private Date       date         ;
    @Column(name="STATE")
    private Integer    state        ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public BookOrder()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------
    //--- DB PRIMARY KEY : ID ( INTEGER ) 
    public void setId( int value )
    {
        this.id = value;
    }
    public int getId()
    {
        return this.id;
    }

    //--- DB COLUMN : SHOP_CODE ( VARCHAR ) 
    public void setShopCode( String value )
    {
        this.shopCode = value;
    }
    public String getShopCode()
    {
        return this.shopCode;
    }

    //--- DB COLUMN : CUSTOMER_CODE ( VARCHAR ) 
    public void setCustomerCode( String value )
    {
        this.customerCode = value;
    }
    public String getCustomerCode()
    {
        return this.customerCode;
    }

    //--- DB COLUMN : EMPLOYEE_CODE ( VARCHAR ) 
    public void setEmployeeCode( String value )
    {
        this.employeeCode = value;
    }
    public String getEmployeeCode()
    {
        return this.employeeCode;
    }

    //--- DB COLUMN : DATE ( DATE ) 
    public void setDate( Date value )
    {
        this.date = value;
    }
    public Date getDate()
    {
        return this.date;
    }

    //--- DB COLUMN : STATE ( INTEGER ) 
    public void setState( Integer value )
    {
        this.state = value;
    }
    public Integer getState()
    {
        return this.state;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
