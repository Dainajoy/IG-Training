package com.java.Polymorphism;
class ParentClass{
    public static void display(){
        System.out.println("Static method");
    }
    void dis(){
        System.out.println("Non Static Method ");
    }
}
class ChildClass extends  ParentClass{
    public static void display(){
        System.out.println("Static  child method");
    }
    void dis(){
        System.out.println("Non Static child method ");
    }
}
public class OverridingWithStaticMethod {
    public static void main(String[] args) {
        ParentClass child=new ChildClass();// the  static method according to the type of reference
        child.dis();
        child.display();

    }
}
