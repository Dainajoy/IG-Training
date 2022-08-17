package com.java.abstraction;
 abstract class AbstractWithCon {
    abstract void m1();
     AbstractWithCon()
     {
         System.out.println("Red");
     }
    static void m2()
    {
        System.out.println("Orange");
    }
}
 class SubclassAbstract extends AbstractWithCon {
    void m1(){
        AbstractWithCon.m2();
        System.out.println("Pink");
    }
}
public class AbstractionWithConstructor {
    public static void main(String[] args) {
        SubclassAbstract sub=new SubclassAbstract();
        sub.m1();
        AbstractWithCon co=new SubclassAbstract();
        co.m1();


    }
}
