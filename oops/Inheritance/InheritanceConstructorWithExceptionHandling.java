package com.java.Inheritance;

import java.io.IOException;
import java.sql.SQLException;

class Parent {
    Parent()
    {
        System.out.println("parent class constructor");
    }
    //Case2:parent class throw a checked exception
    /*Parent() throws IOException
    {
        System.out.println("parent class constructor");
    }*/
}
 class Child extends Parent {
    /*child class throw same or super class exception
    Child() throws Exception {
        System.out.println(
                "child class constructor throwing Exception");
    }*/
     Child() throws ArithmeticException{

     }
}
public class InheritanceConstructorWithExceptionHandling {
    public static void main(String[] args) throws Exception{
        Child child = new Child();
    }
}
