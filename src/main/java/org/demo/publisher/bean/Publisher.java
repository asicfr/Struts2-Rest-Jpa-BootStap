/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 14:48:57 )
 */
// This Bean has a basic Primary Key (not composite) 

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
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="CODE", nullable=false)
    private int        code         ;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    
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
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setCode( int value )
    {
        this.code = value;
    }
    public int getCode()
    {
        return this.code;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABSE MAPPING : COUNTRY_CODE ( VARCHAR ) 
    public void setCountryCode( String value )
    {
        this.countryCode = value;
    }
    public String getCountryCode()
    {
        return this.countryCode;
    }

    //--- DATABSE MAPPING : NAME ( VARCHAR ) 
    public void setName( String value )
    {
        this.name = value;
    }
    public String getName()
    {
        return this.name;
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

    //--- DATABSE MAPPING : CONTACT ( VARCHAR ) 
    public void setContact( String value )
    {
        this.contact = value;
    }
    public String getContact()
    {
        return this.contact;
    }

    //--- DATABSE MAPPING : CITY ( VARCHAR ) 
    public void setCity( String value )
    {
        this.city = value;
    }
    public String getCity()
    {
        return this.city;
    }

    //--- DATABSE MAPPING : ZIP_CODE ( INTEGER ) 
    public void setZipCode( Integer value )
    {
        this.zipCode = value;
    }
    public Integer getZipCode()
    {
        return this.zipCode;
    }

    //--- DATABSE MAPPING : PHONE ( VARCHAR ) 
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
