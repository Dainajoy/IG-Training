package com.java8.methodReference;

interface staticMethodInterface{
    void dis();
}
public class MethodReferenceWithStaticMethod  {
    public static void display(){
        System.out.println("Static reference");

    }
    public static void main(String[] args) {
        // Referring static method
        staticMethodInterface ex=MethodReferenceWithStaticMethod::display;
        // Calling interface method
        ex.dis();

    }
}
