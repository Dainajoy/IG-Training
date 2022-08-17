package com.java.Inheritance;
class AA
{
    int x = 20;
    int y = 30;
    void msg1()
    {
        System.out.println("I am msg1 in class AA");
    }
    void msg2()
    {
        System.out.println("I am msg2 in class AA");
    }
}
 class BB extends AA
{
    int y = 50;
    int z = 60; // Overridding method.
    void msg2()
    {
        System.out.println("I am msg2 in class BB");
    }
    void msg3()
    {
        System.out.println("I am msg3 in class BB");
    }
}
public class InhertanceWithOverriding {
    public static void main(String[] args) {
        AA a = new AA(); // 'a' is reference variable of class A and pointing to the object of class AA. Therefore, superclass object reference a is eligible to call only A.

        System.out.println("Value of x: " +a.x); // x of class AA is called.
        System.out.println("Value of y: " +a.y); // y of class AA is called.
        a.msg1(); // msg1 of class AA is called.
        a.msg2(); // msg2 of class AA is called.
        BB b = new BB();
        System.out.println("Value of x: " +b.x);
        System.out.println("Value of y: " +b.y);
        System.out.println("Value of z: " +b.z); // z of class BB is called.

        AA a1 = new BB(); // 'a' is reference variable of class AA but pointing to the object of class BB.
        System.out.println("Value of x: " +a1.x); // x of class AA is called.
        System.out.println("Value of y: " +a1.y); // y of class AA is called.
        a1.msg2();




    }
}
