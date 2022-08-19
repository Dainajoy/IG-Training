package com.designpatterns.singletonPattern;

// Java code to explain cloning
// issue with singleton
class SuperClass implements Cloneable
{
    int i = 10;

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Singleton class
class SingletonDemo1 extends SuperClass
{
    // public instance initialized when loading the class
    public static SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1()
    {
        // private constructor
    }
}

public class SingletonWithClone
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        SingletonDemo1 instance1 = SingletonDemo1.instance;
        SingletonDemo1 instance2 = (SingletonDemo1) instance1.clone();
        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());
    }
}

