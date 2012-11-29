/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */
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
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Id
    @Column(name="CODE", nullable=false, length=4)
    private String     code         ;
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
    @Column(name="EMAIL", length=60)
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
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------
    //--- DB PRIMARY KEY : CODE ( VARCHAR ) 
    public void setCode( String value )
    {
        this.code = value;
    }
    public String getCode()
    {
        return this.code;
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

    //--- DB COLUMN : FIRST_NAME ( VARCHAR ) 
    public void setFirstName( String value )
    {
        this.firstName = value;
    }
    public String getFirstName()
    {
        return this.firstName;
    }

    //--- DB COLUMN : LAST_NAME ( VARCHAR ) 
    public void setLastName( String value )
    {
        this.lastName = value;
    }
    public String getLastName()
    {
        return this.lastName;
    }

    //--- DB COLUMN : MANAGER ( SMALLINT ) 
    public void setManager( Short value )
    {
        this.manager = value;
    }
    public Short getManager()
    {
        return this.manager;
    }

    //--- DB COLUMN : BADGE_NUMBER ( INTEGER ) 
    public void setBadgeNumber( Integer value )
    {
        this.badgeNumber = value;
    }
    public Integer getBadgeNumber()
    {
        return this.badgeNumber;
    }

    //--- DB COLUMN : EMAIL ( VARCHAR ) 
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
