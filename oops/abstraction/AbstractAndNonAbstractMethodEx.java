package com.java.abstraction;
abstract class AbstractAndNonAbstract {
    abstract void m1();
    void m2(){
        System.out.println("One");
    }
}
class Subclass extends AbstractAndNonAbstract {
    @Override
    void m1() {
        System.out.println("three");
    }

    void m2(){
        System.out.println("Two");
        super.m2();

    }
}

public class AbstractAndNonAbstractMethodEx {
    public static void main(String[] args) {
        Subclass b = new Subclass();
        b.m2();
        b.m1();
    }
}
