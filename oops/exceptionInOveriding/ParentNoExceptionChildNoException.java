package com.java.exceptionInOveriding;
import java.io.*;

class SuperClass {

    // SuperClass doesn't declare any exception
    void method() {
        System.out.println("SuperClass");
    }
}
public class ParentNoExceptionChildNoException  extends SuperClass{
    void method(){
        System.out.println("Inside child Class");
    }

    public static void main(String[] args) {
        ParentNoExceptionChildNoException ex=new ParentNoExceptionChildNoException();

        ex.method();

    }
}
