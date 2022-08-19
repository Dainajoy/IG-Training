package com.designpatterns.singletonPattern;

public class SynchronizedSingletonPattern {
    public static SynchronizedSingletonPattern obj1=null;
    private SynchronizedSingletonPattern(){

    }
    public static SynchronizedSingletonPattern getInstance(){
        if(obj1==null)
        obj1=new SynchronizedSingletonPattern();//lazy Instantiation
        return obj1;

    }

    public static void main(String[] args) {
        SynchronizedSingletonPattern sm=new SynchronizedSingletonPattern();
        System.out.println(sm.getInstance());
    }
}
