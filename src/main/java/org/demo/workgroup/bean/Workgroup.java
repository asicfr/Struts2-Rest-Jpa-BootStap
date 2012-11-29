/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:27 )
 */
package org.demo.workgroup.bean;


import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="WORKGROUP", schema="ROOT" )
public class Workgroup implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    //----------------------------------------------------------------------
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    
    @Id
    @Column(name="ID", nullable=false)
    private short      id           ;
    @Column(name="NAME", nullable=false, length=40)
    private String     name         ;
    @Column(name="DESCRIPTION", nullable=false, length=600)
    private String     description  ;
    @Temporal(TemporalType.DATE)
    @Column(name="CREATION_DATE", nullable=false)
    private Date       creationDate ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Workgroup()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------
    //--- DB PRIMARY KEY : ID ( SMALLINT ) 
    public void setId( short value )
    {
        this.id = value;
    }
    public short getId()
    {
        return this.id;
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

    //--- DB COLUMN : DESCRIPTION ( VARCHAR ) 
    public void setDescription( String value )
    {
        this.description = value;
    }
    public String getDescription()
    {
        return this.description;
    }

    //--- DB COLUMN : CREATION_DATE ( DATE ) 
    public void setCreationDate( Date value )
    {
        this.creationDate = value;
    }
    public Date getCreationDate()
    {
        return this.creationDate;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
