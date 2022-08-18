package com.java.abstraction;

import javax.rmi.CORBA.StubDelegate;

interface person{
    void dis();
}
class student implements person{

    @Override
    public void dis() {
        System.out.println("This is the implementation of person inside student class");
    }
}
class Employee implements person{

    @Override
    public void dis() {
        System.out.println("This is the implementation of person in Employee class");
    }
}
public class AbstractionWithInterface  {
    public static void main(String[] args) {
        person op=new student();
        op.dis();
        person op1=new Employee();
        op1.dis();
    }

}
