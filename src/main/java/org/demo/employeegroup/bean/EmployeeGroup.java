/*
 * Dto class 
 * Created on 29 nov. 2012 ( Time 10:46:26 )
 */

package org.demo.employeegroup.bean ;


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
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    
	@EmbeddedId
    private EmployeeGroupKey key;

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR ENTITY KEY FIELDS
    //----------------------------------------------------------------------
    
	public EmployeeGroupKey getKey() {
        return key;
    }
 
    public void setKey(EmployeeGroupKey keyIn) {
        this.key = keyIn;
    }
    
    //----------------------------------------------------------------------
    // ENTITY ATTRIBUTES 
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
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------

    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


}
