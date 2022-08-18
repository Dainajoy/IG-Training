package com.java.exceptionInOveriding;

public class ParentClassNoExceptionChildWithUnCheckedException extends SuperClass{
    void method ()throws ArithmeticException{
        System.out.println("Inside child with unchecked exception");
    }

    public static void main(String[] args) {
        ParentClassNoExceptionChildWithUnCheckedException ex=new ParentClassNoExceptionChildWithUnCheckedException();
        ex.method();
    }
}
