package com.java.Polymorphism;
class Shape{
    void draw()
    {
        System.out.println("drawing...");
    }
}
class Rectangle extends Shape{
    @Override
    void draw()
    {
        System.out.println("drawing rectangle...");
    }
}
class Circle extends Shape{
    @Override
    void draw()
    {
        System.out.println("drawing circle...");
    }
}
class Triangle extends Shape{
    @Override
    void draw()
    {
        System.out.println("drawing triangle...");
    }
}
public class PolymorphismOverridingDemo {
    public static void main(String[] args) {
        Shape s;
        s=new Rectangle();
        s.draw();
        s=new Circle();
        s.draw();
        s=new Triangle();
        s.draw();
    }

}
