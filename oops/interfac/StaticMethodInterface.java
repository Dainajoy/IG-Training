package com.java.interfac;


interface NewInterface {
    static void hello()
    {
        System.out.println("Hello, New Static Method Here");
    }
    void overrideMethod(String str);
}



public class StaticMethodInterface implements NewInterface{


    public static void main(String[] args) {
        StaticMethodInterface obj = new StaticMethodInterface();
        obj.overrideMethod("StaticMethodInterface");
        NewInterface.hello();

    }

    @Override
    public void overrideMethod(String str) {
        System.out.println("Inside implemented class "+str);
    }
}