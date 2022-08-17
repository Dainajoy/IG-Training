package com.java.Polymorphism;
class demo{
    demo(){
        System.out.println("Default Constructor");
    }
    demo(int a){
        System.out.println("Constructor with parameter:"+a);
    }
}
public class ConstructorOverloading {
    public static void main(String[] args) {
        demo de=new demo();
        demo de1=new demo(4);
    }
}
