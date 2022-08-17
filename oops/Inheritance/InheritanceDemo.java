package com.java.Inheritance;
class BaseClass1
{
    BaseClass1()
    {
        System.out.println(" constructor in BaseClass1");

    }
    void base1Show()
    {
        System.out.println("Show method in BaseClass1");
    }
}
class Baseclass2 extends  BaseClass1{
    Baseclass2(){
        System.out.println(" constructor in BaseClass2");
    }
    void base2Show(){
        System.out.println("Show method in baseclass2");
    }
}
 class SubClas extends Baseclass2
{
    SubClas()
    {

        System.out.println(" constructor in SubClas");
    }
    void subClassShow() {
        System.out.println(" method in SubClas");
    }
}
public class InheritanceDemo {
    public static void main(String[] args) {
        SubClas obj = new SubClas();
        obj.subClassShow();
        obj.base2Show();
        obj.base1Show();

// Superclass reference is equal to child class object.


    }
}

