package com.java.exceptionInOveriding;

public class ParentWithExceptionChildWithSuperException extends parentClass  {
   void dis() throws Exception{//compiler Error
        System.out.println("Inside child with super type exception");
    }

    public static void main(String[] args)  throws Exception{
        ParentWithExceptionChildWithSuperException ex=new ParentWithExceptionChildWithSuperException();
        ex.dis();;
    }
}
