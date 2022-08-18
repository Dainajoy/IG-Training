package com.java.exceptionInAbstraction;

import java.io.IOException;

abstract class MyClass {
    public abstract void display() throws IOException;
}
public class ChildClassThrowSameException extends MyClass{
    @Override
    public void display() throws IOException {
        System.out.println("This is the implementation of display");
    }

    public static void main(String[] args) throws IOException {
        ChildClassThrowSameException ex=new ChildClassThrowSameException();
        ex.display();
    }
}
