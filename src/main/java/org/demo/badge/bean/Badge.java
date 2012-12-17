/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 14:48:55 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.badge.bean;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="BADGE", schema="ROOT" )
public class Badge implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="BADGE_NUMBER", nullable=false)
    private int        badgeNumber  ;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="AUTHORIZATION_LEVEL", nullable=false)
    private short      authorizationLevel ;
    @Temporal(TemporalType.DATE)
    @Column(name="END_OF_VALIDITY")
    private Date       endOfValidity ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Badge()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setBadgeNumber( int value )
    {
        this.badgeNumber = value;
    }
    public int getBadgeNumber()
    {
        return this.badgeNumber;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABSE MAPPING : AUTHORIZATION_LEVEL ( SMALLINT ) 
    public void setAuthorizationLevel( short value )
    {
        this.authorizationLevel = value;
    }
    public short getAuthorizationLevel()
    {
        return this.authorizationLevel;
    }

    //--- DATABSE MAPPING : END_OF_VALIDITY ( DATE ) 
    public void setEndOfValidity( Date value )
    {
        this.endOfValidity = value;
    }
    public Date getEndOfValidity()
    {
        return this.endOfValidity;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
