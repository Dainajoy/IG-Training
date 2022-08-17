package com.java.Inheritance;
 class Animal
{
    void food()
    {
        System.out.println("What kind of food do lions eat?");
    }
}
 class Lion extends Animal
{
    void food(int x)
    {
        System.out.println("Lions eat flesh");
    }
}
public class InheritanceWithOverloading {
    public static void main(String[] args) {
        Animal a = new Lion();
        a.food();  // food() method of class Animal is called.
        // a.food(20);  // Compile time error.

        Lion l = new Lion();
        l.food();  // food() method of class Lion is called.
        l.food(10); // food() method of class Lion is called.
    }
}
