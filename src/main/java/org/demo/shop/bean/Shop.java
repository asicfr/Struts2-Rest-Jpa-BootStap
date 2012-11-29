/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */
package org.demo.shop.bean;


import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

@Entity
@Table(name="SHOP", schema="ROOT" )
public class Shop implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    //----------------------------------------------------------------------
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Id
    @Column(name="CODE", nullable=false, length=3)
    private String     code         ;
    @Column(name="NAME", length=80)
    private String     name         ;
    @Column(name="ADDRESS_1", length=80)
    private String     address1     ;
    @Column(name="ADDRESS_2", length=80)
    private String     address2     ;
    @Column(name="ZIP_CODE")
    private Integer    zipCode      ;
    @Column(name="CITY", length=45)
    private String     city         ;
    @Column(name="COUNTRY_CODE", nullable=false, length=2)
    private String     countryCode  ;
    @Column(name="PHONE", length=14)
    private String     phone        ;
    @Column(name="EMAIL", length=50)
    private String     email        ;
    @Column(name="EXECUTIVE", length=4)
    private String     executive    ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Shop()
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

    //--- DB COLUMN : NAME ( VARCHAR ) 
    public void setName( String value )
    {
        this.name = value;
    }
    public String getName()
    {
        return this.name;
    }

    //--- DB COLUMN : ADDRESS_1 ( VARCHAR ) 
    public void setAddress1( String value )
    {
        this.address1 = value;
    }
    public String getAddress1()
    {
        return this.address1;
    }

    //--- DB COLUMN : ADDRESS_2 ( VARCHAR ) 
    public void setAddress2( String value )
    {
        this.address2 = value;
    }
    public String getAddress2()
    {
        return this.address2;
    }

    //--- DB COLUMN : ZIP_CODE ( INTEGER ) 
    public void setZipCode( Integer value )
    {
        this.zipCode = value;
    }
    public Integer getZipCode()
    {
        return this.zipCode;
    }

    //--- DB COLUMN : CITY ( VARCHAR ) 
    public void setCity( String value )
    {
        this.city = value;
    }
    public String getCity()
    {
        return this.city;
    }

    //--- DB COLUMN : COUNTRY_CODE ( VARCHAR ) 
    public void setCountryCode( String value )
    {
        this.countryCode = value;
    }
    public String getCountryCode()
    {
        return this.countryCode;
    }

    //--- DB COLUMN : PHONE ( VARCHAR ) 
    public void setPhone( String value )
    {
        this.phone = value;
    }
    public String getPhone()
    {
        return this.phone;
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

    //--- DB COLUMN : EXECUTIVE ( VARCHAR ) 
    public void setExecutive( String value )
    {
        this.executive = value;
    }
    public String getExecutive()
    {
        return this.executive;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
