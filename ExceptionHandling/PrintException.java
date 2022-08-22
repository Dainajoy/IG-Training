package com.java.Exception;

public class PrintException {
    public static void main (String[] args) {
        int a=5;
        int b=0;
        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            System.out.println("Print Exception With getMessage():-"+e.getMessage());
            System.out.println("Print Exception With toString():-"+e.toString());
            e.printStackTrace();
        }
    }
}
