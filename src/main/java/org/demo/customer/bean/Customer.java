/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */
package org.demo.customer.bean;


import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

@Entity
@Table(name="CUSTOMER", schema="ROOT" )
public class Customer implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    //----------------------------------------------------------------------
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Id
    @Column(name="CODE", nullable=false, length=5)
    private String     code         ;
    @Column(name="COUNTRY_CODE", nullable=false, length=2)
    private String     countryCode  ;
    @Column(name="FIRST_NAME", length=40)
    private String     firstName    ;
    @Column(name="LAST_NAME", length=40)
    private String     lastName     ;
    @Column(name="LOGIN", nullable=false, length=20)
    private String     login        ;
    @Column(name="PASSWORD", length=20)
    private String     password     ;
    @Column(name="AGE")
    private Integer    age          ;
    @Column(name="CITY", length=45)
    private String     city         ;
    @Column(name="ZIP_CODE")
    private Integer    zipCode      ;
    @Column(name="PHONE", length=20)
    private String     phone        ;
    @Column(name="REVIEWER")
    private Short      reviewer     ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Customer()
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

    //--- DB COLUMN : COUNTRY_CODE ( VARCHAR ) 
    public void setCountryCode( String value )
    {
        this.countryCode = value;
    }
    public String getCountryCode()
    {
        return this.countryCode;
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

    //--- DB COLUMN : LOGIN ( VARCHAR ) 
    public void setLogin( String value )
    {
        this.login = value;
    }
    public String getLogin()
    {
        return this.login;
    }

    //--- DB COLUMN : PASSWORD ( VARCHAR ) 
    public void setPassword( String value )
    {
        this.password = value;
    }
    public String getPassword()
    {
        return this.password;
    }

    //--- DB COLUMN : AGE ( INTEGER ) 
    public void setAge( Integer value )
    {
        this.age = value;
    }
    public Integer getAge()
    {
        return this.age;
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

    //--- DB COLUMN : REVIEWER ( SMALLINT ) 
    public void setReviewer( Short value )
    {
        this.reviewer = value;
    }
    public Short getReviewer()
    {
        return this.reviewer;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
