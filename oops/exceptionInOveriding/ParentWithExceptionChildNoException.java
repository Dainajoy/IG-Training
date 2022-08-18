package com.java.exceptionInOveriding;

import java.io.IOException;

class parentClass{
    void dis() throws IOException {
        System.out.println("Inside superclass with Exception");
    }
}
public class ParentWithExceptionChildNoException  extends parentClass{
    void dis(){
        System.out.println("Child class without Exception");
    }

    public static void main(String[] args) {
        ParentWithExceptionChildNoException ex=new ParentWithExceptionChildNoException();
        ex.dis();
    }
}
