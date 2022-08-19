package com.designpatterns.singletonPattern;


// Java code to explain overcome
// cloning issue with singleton
class SuperClassDemo implements Cloneable
{
    int i = 10;

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Singleton class
class SingletonClone extends SuperClassDemo
{
    // public instance initialized when loading the class
    public static SingletonClone instance = new SingletonClone();

    private SingletonClone()
    {
        // private constructor
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        //throw new CloneNotSupportedException();//Exception take place
        return instance;
    }
}

public class PreventionFromCloneable
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        SingletonClone instance1 = SingletonClone.instance;
        SingletonClone instance2 = (SingletonClone) instance1.clone();
        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());//same object instance1 and instance2
    }
}
