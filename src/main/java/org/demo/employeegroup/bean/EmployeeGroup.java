/*
 * Dto class 
 * Created on 17 déc. 2012 ( Time 15:40:00 )
 */
// This Bean has a composite Primary Key  


package org.demo.employeegroup.bean;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

@Entity
@Table(name="EMPLOYEE_GROUP", schema="ROOT" )
public class EmployeeGroup implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
	@EmbeddedId
    private EmployeeGroupKey key;


    //----------------------------------------------------------------------
    // ENTITY FIELDS 
    //----------------------------------------------------------------------    

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public EmployeeGroup()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------
    
	public EmployeeGroupKey getKey() {
        return key;
    }
 
    public void setKey(EmployeeGroupKey keyIn) {
        this.key = keyIn;
    }
    

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------

    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
