package com.java.exceptionInAbstraction;

import java.io.IOException;

public class ChildClassNotThrowException  extends MyClass{
    @Override
    public void display()  {
        System.out.println("Implementation of display in childclass without any exception");
    }

    public static void main(String[] args) {
        ChildClassNotThrowException ex=new ChildClassNotThrowException();

        ex.display();
    }
}
