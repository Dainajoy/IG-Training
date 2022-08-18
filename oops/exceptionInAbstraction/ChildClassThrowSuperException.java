package com.java.exceptionInAbstraction;

import java.io.IOException;

public class ChildClassThrowSuperException extends MyClass{
    @Override
    public void display() throws Exception {
        System.out.println("Display implementation with super exception");
    }

    public static void main(String[] args) throws Exception {
        ChildClassThrowSuperException ex=new ChildClassThrowSuperException();
        ex.display();
    }


}
