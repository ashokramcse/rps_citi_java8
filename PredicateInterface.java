package com.rps.facades;

public interface PredicateInterface {
static Boolean checkAge(int age){  
        if(age>17)  
            return true;  
        else return false;  
    }  
}
