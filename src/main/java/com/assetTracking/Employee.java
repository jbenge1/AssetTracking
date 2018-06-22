package com.assetTracking;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("request")
public class Employee {
    
    private int id;
    private String firstName, lastName, emailAddr;

    public Employee() {}
    
    public Employee(int id, String firstName, String lastName, String emailAddr) {
        this.id        = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.emailAddr = emailAddr;
    }


    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmailAddr(){
        return this.emailAddr;
    }
    
    @Override
    public String toString() {
    	return String.format("ID=%d, First Name=%s, Last Name=%s, Email Address=%s", this.id,this.firstName,this.lastName,this.emailAddr);
    }
}
