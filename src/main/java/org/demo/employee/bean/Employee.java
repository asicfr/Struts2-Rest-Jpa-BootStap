/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 15:40:00 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.employee.bean;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

@Entity
@Table(name="EMPLOYEE", schema="ROOT" )
public class Employee implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="CODE", nullable=false, length=4)
    private String     code         ;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="SHOP_CODE", nullable=false, length=3)
    private String     shopCode     ;
    @Column(name="FIRST_NAME", length=40)
    private String     firstName    ;
    @Column(name="LAST_NAME", nullable=false, length=40)
    private String     lastName     ;
    @Column(name="MANAGER")
    private Short      manager      ;
    @Column(name="BADGE_NUMBER")
    private Integer    badgeNumber  ;
    @Column(name="EMAIL", length=320)
    private String     email        ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Employee()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setCode( String value )
    {
        this.code = value;
    }
    public String getCode()
    {
        return this.code;
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

    //--- DATABSE MAPPING : FIRST_NAME ( VARCHAR ) 
    public void setFirstName( String value )
    {
        this.firstName = value;
    }
    public String getFirstName()
    {
        return this.firstName;
    }

    //--- DATABSE MAPPING : LAST_NAME ( VARCHAR ) 
    public void setLastName( String value )
    {
        this.lastName = value;
    }
    public String getLastName()
    {
        return this.lastName;
    }

    //--- DATABSE MAPPING : MANAGER ( SMALLINT ) 
    public void setManager( Short value )
    {
        this.manager = value;
    }
    public Short getManager()
    {
        return this.manager;
    }

    //--- DATABSE MAPPING : BADGE_NUMBER ( INTEGER ) 
    public void setBadgeNumber( Integer value )
    {
        this.badgeNumber = value;
    }
    public Integer getBadgeNumber()
    {
        return this.badgeNumber;
    }

    //--- DATABSE MAPPING : EMAIL ( VARCHAR ) 
    public void setEmail( String value )
    {
        this.email = value;
    }
    public String getEmail()
    {
        return this.email;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
