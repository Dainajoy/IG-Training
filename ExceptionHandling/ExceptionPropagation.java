package com.java.Exception;

public class ExceptionPropagation {
    void m(){
       // throw new java.io.IOException("device error");//checked exception will lead to complie time error
        int data=50/0;//unchecked exceptions under propagation
    }
    void n(){
        m();
    }
    void p(){
        try{
            n();
        }catch(Exception e){System.out.println("exception handeled");}
    }

    public static void main(String[] args) {
        ExceptionPropagation obj=new ExceptionPropagation();
        obj.p();
        System.out.println("normal flow...");
    }
}
