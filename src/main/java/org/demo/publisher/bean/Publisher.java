/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */
package org.demo.publisher.bean;


import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

@Entity
@Table(name="PUBLISHER", schema="ROOT" )
public class Publisher implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    //----------------------------------------------------------------------
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Id
    @Column(name="CODE", nullable=false)
    private int        code         ;
    @Column(name="COUNTRY_CODE", nullable=false, length=2)
    private String     countryCode  ;
    @Column(name="NAME", length=45)
    private String     name         ;
    @Column(name="EMAIL", length=45)
    private String     email        ;
    @Column(name="CONTACT", length=45)
    private String     contact      ;
    @Column(name="CITY", length=45)
    private String     city         ;
    @Column(name="ZIP_CODE")
    private Integer    zipCode      ;
    @Column(name="PHONE", length=14)
    private String     phone        ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Publisher()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------
    //--- DB PRIMARY KEY : CODE ( INTEGER ) 
    public void setCode( int value )
    {
        this.code = value;
    }
    public int getCode()
    {
        return this.code;
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

    //--- DB COLUMN : NAME ( VARCHAR ) 
    public void setName( String value )
    {
        this.name = value;
    }
    public String getName()
    {
        return this.name;
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

    //--- DB COLUMN : CONTACT ( VARCHAR ) 
    public void setContact( String value )
    {
        this.contact = value;
    }
    public String getContact()
    {
        return this.contact;
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

    //--- DB COLUMN : ZIP_CODE ( INTEGER ) 
    public void setZipCode( Integer value )
    {
        this.zipCode = value;
    }
    public Integer getZipCode()
    {
        return this.zipCode;
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


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
