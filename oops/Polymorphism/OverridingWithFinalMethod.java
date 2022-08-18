package com.java.Polymorphism;
class ClassWithFinal{
    final int add(int a,int b){
        return (a+b);
    }
    final  int substraction(int a,int b){
        return a-b;
    }
}
class ClassWithoutFinal extends  ClassWithFinal{

    @Override
    int add(int a,int b){//Cannot override
        return a-b;
    }
}
public class OverridingWithFinalMethod {
    public static void main(String[] args) {
        ClassWithoutFinal ov=new ClassWithoutFinal();
        ov.add(3,5);

    }
}
