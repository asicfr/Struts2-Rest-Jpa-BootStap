/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 15:40:01 )
 */
// This Bean has a basic Primary Key (not composite) 

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
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="ID", nullable=false)
    private short      id           ;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    
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
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( short value )
    {
        this.id = value;
    }
    public short getId()
    {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABSE MAPPING : NAME ( VARCHAR ) 
    public void setName( String value )
    {
        this.name = value;
    }
    public String getName()
    {
        return this.name;
    }

    //--- DATABSE MAPPING : DESCRIPTION ( VARCHAR ) 
    public void setDescription( String value )
    {
        this.description = value;
    }
    public String getDescription()
    {
        return this.description;
    }

    //--- DATABSE MAPPING : CREATION_DATE ( DATE ) 
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
