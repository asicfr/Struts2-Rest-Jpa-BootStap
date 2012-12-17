/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 14:48:55 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.author.bean;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

@Entity
@Table(name="AUTHOR", schema="ROOT" )
public class Author implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID", nullable=false)
    private int        id           ;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="FIRST_NAME", length=40)
    private String     firstName    ;
    @Column(name="LAST_NAME", length=40)
    private String     lastName     ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Author()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( int value )
    {
        this.id = value;
    }
    public int getId()
    {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
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


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
