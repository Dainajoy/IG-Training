package com.designpatterns.singletonPattern;

public class EagerInitializedSingleton {
    private static EagerInitializedSingleton obj=new EagerInitializedSingleton();
    private EagerInitializedSingleton(){

    }
    public static EagerInitializedSingleton getInstance(){
        return obj;
    }


}
