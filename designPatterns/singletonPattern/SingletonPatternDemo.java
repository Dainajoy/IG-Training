package com.designpatterns.singletonPattern;


public class SingletonPatternDemo {
    private  static SingletonPatternDemo instance=null;
    private SingletonPatternDemo(){

    }
    public static SingletonPatternDemo getInstance(){
        if(instance ==null)
            instance= new SingletonPatternDemo();

            return instance;
    }
    public static void main(String[] args) {
        SingletonPatternDemo demo=new SingletonPatternDemo();
        System.out.println(demo.getInstance());


    }
}
