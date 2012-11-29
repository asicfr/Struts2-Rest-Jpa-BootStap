/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:25 )
 */
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
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Id
    @Column(name="BADGE_NUMBER", nullable=false)
    private int        badgeNumber  ;
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
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------
    //--- DB PRIMARY KEY : BADGE_NUMBER ( INTEGER ) 
    public void setBadgeNumber( int value )
    {
        this.badgeNumber = value;
    }
    public int getBadgeNumber()
    {
        return this.badgeNumber;
    }

    //--- DB COLUMN : AUTHORIZATION_LEVEL ( SMALLINT ) 
    public void setAuthorizationLevel( short value )
    {
        this.authorizationLevel = value;
    }
    public short getAuthorizationLevel()
    {
        return this.authorizationLevel;
    }

    //--- DB COLUMN : END_OF_VALIDITY ( DATE ) 
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
