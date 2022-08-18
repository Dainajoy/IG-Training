package com.java.exceptionInAbstraction;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ChildClassThrowSubException  extends MyClass{
    @Override
    public void display() throws FileNotFoundException {
        System.out.println("Implementation of display with sub type exception in subclass");
    }

    public static void main(String[] args) throws FileNotFoundException {
        ChildClassThrowSubException ex=new ChildClassThrowSubException();
        ex.display();
    }
}
