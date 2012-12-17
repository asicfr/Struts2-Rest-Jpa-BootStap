/*
 * Dto key class 
 * Created on 17 déc. 2012 ( Time 14:48:56 )
 */

package org.demo.employeegroup.bean;

import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.* ;
import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

@Embeddable
public class EmployeeGroupKey implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="EMPLOYEE_CODE", nullable=false, length=4)
    private String     employeeCode ;
    
    @Column(name="GROUP_ID", nullable=false)
    private short      groupId      ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public EmployeeGroupKey()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setEmployeeCode( String value )
    {
        this.employeeCode = value;
    }
    public String getEmployeeCode()
    {
        return this.employeeCode;
    }

    public void setGroupId( short value )
    {
        this.groupId = value;
    }
    public short getGroupId()
    {
        return this.groupId;
    }


    

}
