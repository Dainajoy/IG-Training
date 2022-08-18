package com.java.exceptionInOveriding;

import java.io.IOException;

public class ParentNoExceptionChildWithCheckedException extends SuperClass{
    void method() throws IOException{//complier error
        System.out.println("Inside childclass with checked exception");
    }

    public static void main(String[] args) throws IOException {
        ParentNoExceptionChildWithCheckedException ex=new ParentNoExceptionChildWithCheckedException();
        //ex.method();
    }
}
