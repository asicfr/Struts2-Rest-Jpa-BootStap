/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 14:48:55 )
 */
// This Bean has a basic Primary Key (not composite) 

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
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID", nullable=false)
    private int        id           ;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    
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
    //--- DATABSE MAPPING : SHOP_CODE ( VARCHAR ) 
    public void setShopCode( String value )
    {
        this.shopCode = value;
    }
    public String getShopCode()
    {
        return this.shopCode;
    }

    //--- DATABSE MAPPING : CUSTOMER_CODE ( VARCHAR ) 
    public void setCustomerCode( String value )
    {
        this.customerCode = value;
    }
    public String getCustomerCode()
    {
        return this.customerCode;
    }

    //--- DATABSE MAPPING : EMPLOYEE_CODE ( VARCHAR ) 
    public void setEmployeeCode( String value )
    {
        this.employeeCode = value;
    }
    public String getEmployeeCode()
    {
        return this.employeeCode;
    }

    //--- DATABSE MAPPING : DATE ( DATE ) 
    public void setDate( Date value )
    {
        this.date = value;
    }
    public Date getDate()
    {
        return this.date;
    }

    //--- DATABSE MAPPING : STATE ( INTEGER ) 
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
