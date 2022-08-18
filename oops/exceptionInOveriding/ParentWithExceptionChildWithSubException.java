package com.java.exceptionInOveriding;

import java.nio.file.FileAlreadyExistsException;

public class ParentWithExceptionChildWithSubException extends parentClass{
 void dis() throws FileAlreadyExistsException {
     System.out.println("Child class with sub type of exception");
 }

    public static void main(String[] args)  throws FileAlreadyExistsException{
        ParentWithExceptionChildWithSubException ex=new ParentWithExceptionChildWithSubException();
        ex.dis();
    }
}
